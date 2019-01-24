package com.zj.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.zj.common.base.BaseService;
import com.zj.upms.dao.model.UpmsUserPermission;
import com.zj.upms.dao.model.UpmsUserPermissionExample;

/**
* UpmsUserPermissionService接口
* Created by zj on 2019/1/24.
*/
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {
    /**
     * 用户权限
     * @param datas 权限数据
     * @param id 用户id
     * @return
     */
    int permission(JSONArray datas, int id);

}