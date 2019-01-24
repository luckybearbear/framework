package com.zj.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.zj.common.base.BaseService;
import com.zj.upms.dao.model.UpmsRolePermission;
import com.zj.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* Created by zj on 2019/1/24.
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {
    /**
     * 角色权限
     * @param datas 权限数据
     * @param id 角色id
     * @return
     */
    int rolePermission(JSONArray datas, int id);
}