package com.zj.upms.rpc.api;

import com.zj.common.base.BaseService;
import com.zj.upms.dao.model.UpmsUserRole;
import com.zj.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* Created by zj on 2019/1/24.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {
    /**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, int id);

}