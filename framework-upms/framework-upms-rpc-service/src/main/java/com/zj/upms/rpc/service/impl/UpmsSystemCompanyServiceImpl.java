package com.zj.upms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.upms.dao.mapper.UpmsSystemCompanyMapper;
import com.zj.upms.dao.model.UpmsSystemCompany;
import com.zj.upms.dao.model.UpmsSystemCompanyExample;
import com.zj.upms.rpc.api.UpmsSystemCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsSystemCompanyService实现
* Created by zj on 2019/1/29.
*/
@Service
@Transactional
@BaseService
public class UpmsSystemCompanyServiceImpl extends BaseServiceImpl<UpmsSystemCompanyMapper, UpmsSystemCompany, UpmsSystemCompanyExample> implements UpmsSystemCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsSystemCompanyServiceImpl.class);

    @Autowired
    UpmsSystemCompanyMapper upmsSystemCompanyMapper;

}