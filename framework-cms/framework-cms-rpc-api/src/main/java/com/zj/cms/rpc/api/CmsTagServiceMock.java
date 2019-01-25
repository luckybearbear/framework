package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsTagMapper;
import com.zj.cms.dao.model.CmsTag;
import com.zj.cms.dao.model.CmsTagExample;

/**
* 降级实现CmsTagService接口
* Created by zj on 2019/1/25.
*/
public class CmsTagServiceMock extends BaseServiceMock<CmsTagMapper, CmsTag, CmsTagExample> implements CmsTagService {

}
