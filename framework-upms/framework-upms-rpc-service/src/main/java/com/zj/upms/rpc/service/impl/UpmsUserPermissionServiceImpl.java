package com.zj.upms.rpc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.upms.dao.mapper.UpmsUserPermissionMapper;
import com.zj.upms.dao.model.UpmsUserPermission;
import com.zj.upms.dao.model.UpmsUserPermissionExample;
import com.zj.upms.rpc.api.UpmsUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserPermissionService实现
* Created by zj on 2019/1/24.
*/
@Service
@Transactional
@BaseService
public class UpmsUserPermissionServiceImpl extends BaseServiceImpl<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserPermissionServiceImpl.class);

    @Autowired
    UpmsUserPermissionMapper upmsUserPermissionMapper;

    @Override
    public int permission(JSONArray datas, int id) {
        for (int i = 0; i < datas.size(); i ++) {
            JSONObject json = datas.getJSONObject(i);
            if (json.getBoolean("checked")) {
                // 新增权限
                UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
                upmsUserPermission.setUserId(id);
                upmsUserPermission.setPermissionId(json.getIntValue("id"));
                upmsUserPermission.setType(json.getByte("type"));
                upmsUserPermissionMapper.insertSelective(upmsUserPermission);
            } else {
                // 删除权限
                UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
                upmsUserPermissionExample.createCriteria()
                        .andPermissionIdEqualTo(json.getIntValue("id"))
                        .andTypeEqualTo(json.getByte("type"));
                upmsUserPermissionMapper.deleteByExample(upmsUserPermissionExample);
            }
        }
        return datas.size();
    }
}