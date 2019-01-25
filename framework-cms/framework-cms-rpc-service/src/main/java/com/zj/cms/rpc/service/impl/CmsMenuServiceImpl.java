package com.zj.cms.rpc.service.impl;

import com.zj.common.annotation.BaseService;
import com.zj.common.base.BaseServiceImpl;
import com.zj.cms.dao.mapper.CmsMenuMapper;
import com.zj.cms.dao.model.CmsMenu;
import com.zj.cms.dao.model.CmsMenuExample;
import com.zj.cms.rpc.api.CmsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsMenuService实现
* Created by zj on 2019/1/25.
*/
@Service
@Transactional
@BaseService
public class CmsMenuServiceImpl extends BaseServiceImpl<CmsMenuMapper, CmsMenu, CmsMenuExample> implements CmsMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsMenuServiceImpl.class);

    @Autowired
    CmsMenuMapper cmsMenuMapper;

}