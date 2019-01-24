package com.zj.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.zj.common.base.BaseServiceMock;
import com.zj.upms.dao.mapper.UpmsRolePermissionMapper;
import com.zj.upms.dao.model.UpmsRolePermission;
import com.zj.upms.dao.model.UpmsRolePermissionExample;

/**
* 降级实现UpmsRolePermissionService接口
* Created by zj on 2019/1/24.
*/
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

    @Override
    public int rolePermission(JSONArray datas, int id) {
        return 0;
    }
}
