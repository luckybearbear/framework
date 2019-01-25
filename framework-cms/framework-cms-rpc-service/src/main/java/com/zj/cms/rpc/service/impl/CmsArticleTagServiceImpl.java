package com.zj.cms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.cms.dao.mapper.CmsArticleTagMapper;
import com.zj.cms.dao.model.CmsArticleTag;
import com.zj.cms.dao.model.CmsArticleTagExample;
import com.zj.cms.rpc.api.CmsArticleTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsArticleTagService实现
* Created by zj on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class CmsArticleTagServiceImpl extends BaseServiceImpl<CmsArticleTagMapper, CmsArticleTag, CmsArticleTagExample> implements CmsArticleTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsArticleTagServiceImpl.class);

    @Autowired
    CmsArticleTagMapper cmsArticleTagMapper;

}