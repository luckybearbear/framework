package com.zj.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.zj.common.base.BaseService;
import com.zj.upms.dao.model.UpmsPermission;
import com.zj.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* Created by zj on 2019/1/24.
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {
    JSONArray getTreeByRoleId(Integer roleId);

    JSONArray getTreeByUserId(Integer usereId, Byte type);

}