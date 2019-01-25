package com.zj.cms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.cms.dao.mapper.CmsTagMapper;
import com.zj.cms.dao.model.CmsTag;
import com.zj.cms.dao.model.CmsTagExample;
import com.zj.cms.rpc.api.CmsTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsTagService实现
* Created by zj on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class CmsTagServiceImpl extends BaseServiceImpl<CmsTagMapper, CmsTag, CmsTagExample> implements CmsTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsTagServiceImpl.class);

    @Autowired
    CmsTagMapper cmsTagMapper;

}