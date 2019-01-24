package com.zj.upms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.upms.dao.mapper.UpmsRolePermissionMapper;
import com.zj.upms.dao.model.UpmsRolePermission;
import com.zj.upms.dao.model.UpmsRolePermissionExample;
import com.zj.upms.rpc.api.UpmsRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRolePermissionService实现
* Created by zj on 2019/1/24.
*/
@Service
@Transactional
@BaseService
public class UpmsRolePermissionServiceImpl extends BaseServiceImpl<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRolePermissionServiceImpl.class);

    @Autowired
    UpmsRolePermissionMapper upmsRolePermissionMapper;

}