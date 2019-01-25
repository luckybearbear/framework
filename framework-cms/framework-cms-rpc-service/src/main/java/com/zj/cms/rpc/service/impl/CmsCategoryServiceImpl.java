package com.zj.cms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.cms.dao.mapper.CmsCategoryMapper;
import com.zj.cms.dao.model.CmsCategory;
import com.zj.cms.dao.model.CmsCategoryExample;
import com.zj.cms.rpc.api.CmsCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsCategoryService实现
* Created by zj on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class CmsCategoryServiceImpl extends BaseServiceImpl<CmsCategoryMapper, CmsCategory, CmsCategoryExample> implements CmsCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsCategoryServiceImpl.class);

    @Autowired
    CmsCategoryMapper cmsCategoryMapper;

}