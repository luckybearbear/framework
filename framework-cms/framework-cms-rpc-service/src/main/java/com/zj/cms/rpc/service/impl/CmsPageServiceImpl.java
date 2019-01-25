package com.zj.cms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.cms.dao.mapper.CmsPageMapper;
import com.zj.cms.dao.model.CmsPage;
import com.zj.cms.dao.model.CmsPageExample;
import com.zj.cms.rpc.api.CmsPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsPageService实现
* Created by zj on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class CmsPageServiceImpl extends BaseServiceImpl<CmsPageMapper, CmsPage, CmsPageExample> implements CmsPageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsPageServiceImpl.class);

    @Autowired
    CmsPageMapper cmsPageMapper;

}