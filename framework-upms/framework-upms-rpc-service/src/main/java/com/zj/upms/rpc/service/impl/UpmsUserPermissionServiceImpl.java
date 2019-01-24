package com.zj.upms.rpc.service.impl;

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

}