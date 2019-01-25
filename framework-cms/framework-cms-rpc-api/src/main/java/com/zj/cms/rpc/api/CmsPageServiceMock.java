package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsPageMapper;
import com.zj.cms.dao.model.CmsPage;
import com.zj.cms.dao.model.CmsPageExample;

/**
* 降级实现CmsPageService接口
* Created by zj on 2019/1/25.
*/
public class CmsPageServiceMock extends BaseServiceMock<CmsPageMapper, CmsPage, CmsPageExample> implements CmsPageService {

}
