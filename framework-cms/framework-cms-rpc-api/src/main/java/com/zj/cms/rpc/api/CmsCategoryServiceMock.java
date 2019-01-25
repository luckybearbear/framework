package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsCategoryMapper;
import com.zj.cms.dao.model.CmsCategory;
import com.zj.cms.dao.model.CmsCategoryExample;

/**
* 降级实现CmsCategoryService接口
* Created by zj on 2019/1/25.
*/
public class CmsCategoryServiceMock extends BaseServiceMock<CmsCategoryMapper, CmsCategory, CmsCategoryExample> implements CmsCategoryService {

}
