package com.zj.upms.rpc.api;

import com.zj.common.base.BaseService;
import com.zj.upms.dao.model.UpmsUserOrganization;
import com.zj.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* Created by zj on 2019/1/24.
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {
    /**
     * 用户组织
     * @param organizationIds 组织ids
     * @param id 用户id
     * @return
     */
    int organization(String[] organizationIds, int id);

}