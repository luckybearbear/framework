package com.zj.upms.client.shiro.session;

import com.zj.common.util.RedisUtil;
import com.zj.upms.client.util.SerializableUtil;
import com.zj.upms.common.constant.UpmsConstant;
import com.zj.upms.dao.model.UpmsUser;
import com.zj.upms.rpc.api.UpmsApiService;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.*;

/**
 * 基于redis的sessionDao，缓存共享session
 * Created by zj on 2017/2/23.
 */
public class UpmsSessionDao extends CachingSessionDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsSessionDao.class);
    // 会话key
    private final static String FRAMEWORK_UPMS_SHIRO_SESSION_ID = "framework-upms-shiro-session-id";
    // 全局会话key
    private final static String FRAMEWORK_UPMS_SERVER_SESSION_ID = "framework-upms-server-session-id";
    // 全局会话列表key
    private final static String FRAMEWORK_UPMS_SERVER_SESSION_IDS = "framework-upms-server-session-ids";
    // code key
    private final static String FRAMEWORK_UPMS_SERVER_CODE = "framework-upms-server-code";
    // 局部会话key
    private final static String FRAMEWORK_UPMS_CLIENT_SESSION_ID = "framework-upms-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String FRAMEWORK_UPMS_CLIENT_SESSION_IDS = "framework-upms-client-session-ids";
    @Autowired
    private UpmsApiService upmsApiService;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        RedisUtil.set(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        LOGGER.debug("doCreate >>>>> sessionId={}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String session = RedisUtil.get(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        LOGGER.debug("doReadSession >>>>> sessionId={}", sessionId);
        return SerializableUtil.deserialize(session);
    }

    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        // 更新session的最后一次访问时间
        UpmsSession upmsSession = (UpmsSession) session;
        UpmsSession cacheUpmsSession = (UpmsSession) doReadSession(session.getId());
        if (null != cacheUpmsSession) {
            upmsSession.setStatus(cacheUpmsSession.getStatus());
            upmsSession.setAttribute("FORCE_LOGOUT", cacheUpmsSession.getAttribute("FORCE_LOGOUT"));

            //
            PrincipalCollection principalCollection = (PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (null != principalCollection && null == upmsSession.getUserInfo()) {
                UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(String.valueOf(principalCollection.getPrimaryPrincipal()));
                //为了安全考虑，过滤用户密码相关信息
                upmsUser.setPassword(null);
                upmsUser.setSalt(null);
                upmsSession.setUserInfo(upmsUser);
            }
        }
        RedisUtil.set(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        // 更新FRAMEWORK_UPMS_SERVER_SESSION_ID、FRAMEWORK_UPMS_SERVER_CODE过期时间 TODO
        LOGGER.debug("doUpdate >>>>> sessionId={}", session.getId());
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        String upmsType = ObjectUtils.toString(session.getAttribute(UpmsConstant.UPMS_TYPE));
        if ("client".equals(upmsType)) {
            // 删除局部会话和同一code注册的局部会话
            String code = RedisUtil.get(FRAMEWORK_UPMS_CLIENT_SESSION_ID + "_" + sessionId);
            Jedis jedis = RedisUtil.getJedis();
            jedis.del(FRAMEWORK_UPMS_CLIENT_SESSION_ID + "_" + sessionId);
            jedis.srem(FRAMEWORK_UPMS_CLIENT_SESSION_IDS + "_" + code, sessionId);
            jedis.close();
        }
        if ("server".equals(upmsType)) {
            // 当前全局会话code
            String code = RedisUtil.get(FRAMEWORK_UPMS_SERVER_SESSION_ID + "_" + sessionId);
            // 清除全局会话
            RedisUtil.remove(FRAMEWORK_UPMS_SERVER_SESSION_ID + "_" + sessionId);
            // 清除code校验值
            RedisUtil.remove(FRAMEWORK_UPMS_SERVER_CODE + "_" + code);
            // 清除所有局部会话
            Jedis jedis = RedisUtil.getJedis();
            Set<String> clientSessionIds = jedis.smembers(FRAMEWORK_UPMS_CLIENT_SESSION_IDS + "_" + code);
            for (String clientSessionId : clientSessionIds) {
                jedis.del(FRAMEWORK_UPMS_CLIENT_SESSION_ID + "_" + clientSessionId);
                jedis.srem(FRAMEWORK_UPMS_CLIENT_SESSION_IDS + "_" + code, clientSessionId);
            }
            LOGGER.debug("当前code={}，对应的注册系统个数：{}个", code, jedis.scard(FRAMEWORK_UPMS_CLIENT_SESSION_IDS + "_" + code));
            jedis.close();
            // 维护会话id列表，提供会话分页管理
            RedisUtil.lrem(FRAMEWORK_UPMS_SERVER_SESSION_IDS, 1, sessionId);
        }
        // 删除session
        RedisUtil.remove(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        LOGGER.debug("doUpdate >>>>> sessionId={}", sessionId);
    }

    /**
     * 获取会话列表
     * @param offset
     * @param limit
     * @return
     */
    public Map getActiveSessions(int offset, int limit) {
        Map sessions = new HashMap();
        Jedis jedis = RedisUtil.getJedis();
        // 获取在线会话总数
        long total = jedis.llen(FRAMEWORK_UPMS_SERVER_SESSION_IDS);
        // 获取当前页会话详情
        List<String> ids = jedis.lrange(FRAMEWORK_UPMS_SERVER_SESSION_IDS, offset, (offset + limit - 1));
        List<Session> rows = new ArrayList<>();
        for (String id : ids) {
            String session = RedisUtil.get(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + id);
            // 过滤redis过期session
            if (null == session) {
                RedisUtil.lrem(FRAMEWORK_UPMS_SERVER_SESSION_IDS, 1, id);
                total = total - 1;
                continue;
            }
             rows.add(SerializableUtil.deserialize(session));
        }
        jedis.close();
        sessions.put("total", total);
        sessions.put("rows", rows);
        return sessions;
    }

    /**
     * 强制退出
     * @param ids
     * @return
     */
    public int forceout(String ids) {
        String[] sessionIds = ids.split(",");
        for (String sessionId : sessionIds) {
            // 会话增加强制退出属性标识，当此会话访问系统时，判断有该标识，则退出登录
            String session = RedisUtil.get(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
            UpmsSession upmsSession = (UpmsSession) SerializableUtil.deserialize(session);
            upmsSession.setStatus(UpmsSession.OnlineStatus.force_logout);
            upmsSession.setAttribute("FORCE_LOGOUT", "FORCE_LOGOUT");
            RedisUtil.set(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(upmsSession), (int) upmsSession.getTimeout() / 1000);
        }
        return sessionIds.length;
    }
    /**
     * 获取当前会话用户信息
     *
     * @return
     */
    public UpmsUser getUserInfo(Serializable sessionId) {
        UpmsSession session = (UpmsSession) doReadSession(sessionId);
        if (null == session) {
            return null;
        }
        return session.getUserInfo();
    }

    /**
     * 更改在线状态
     *
     * @param sessionId
     * @param onlineStatus
     */
    public void updateStatus(Serializable sessionId, UpmsSession.OnlineStatus onlineStatus) {
        UpmsSession session = (UpmsSession) doReadSession(sessionId);
        if (null == session) {
            return;
        }
        session.setStatus(onlineStatus);
        RedisUtil.set(FRAMEWORK_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
    }

}
