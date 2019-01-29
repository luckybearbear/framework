package com.zj.upms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.upms.dao.mapper.UpmsCompanyMapper;
import com.zj.upms.dao.model.UpmsCompany;
import com.zj.upms.dao.model.UpmsCompanyExample;
import com.zj.upms.rpc.api.UpmsCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsCompanyService实现
* Created by zj on 2019/1/29.
*/
@Service
@Transactional
@BaseService
public class UpmsCompanyServiceImpl extends BaseServiceImpl<UpmsCompanyMapper, UpmsCompany, UpmsCompanyExample> implements UpmsCompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsCompanyServiceImpl.class);

    @Autowired
    UpmsCompanyMapper upmsCompanyMapper;

}