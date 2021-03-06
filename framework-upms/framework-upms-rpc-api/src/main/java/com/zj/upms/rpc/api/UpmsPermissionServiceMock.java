package com.zj.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.zj.common.base.BaseServiceMock;
import com.zj.upms.dao.mapper.UpmsPermissionMapper;
import com.zj.upms.dao.model.UpmsPermission;
import com.zj.upms.dao.model.UpmsPermissionExample;

/**
* 降级实现UpmsPermissionService接口
* Created by zj on 2019/1/24.
*/
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {

    @Override
    public JSONArray getTreeByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public JSONArray getTreeByUserId(Integer usereId, Byte type) {
        return null;
    }
}
