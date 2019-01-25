package com.zj.cms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.cms.dao.mapper.CmsTopicMapper;
import com.zj.cms.dao.model.CmsTopic;
import com.zj.cms.dao.model.CmsTopicExample;
import com.zj.cms.rpc.api.CmsTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsTopicService实现
* Created by zj on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class CmsTopicServiceImpl extends BaseServiceImpl<CmsTopicMapper, CmsTopic, CmsTopicExample> implements CmsTopicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsTopicServiceImpl.class);

    @Autowired
    CmsTopicMapper cmsTopicMapper;

}