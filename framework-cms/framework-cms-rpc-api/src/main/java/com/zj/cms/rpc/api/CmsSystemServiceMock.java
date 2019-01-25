package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsSystemMapper;
import com.zj.cms.dao.model.CmsSystem;
import com.zj.cms.dao.model.CmsSystemExample;

/**
* 降级实现CmsSystemService接口
* Created by zj on 2019/1/25.
*/
public class CmsSystemServiceMock extends BaseServiceMock<CmsSystemMapper, CmsSystem, CmsSystemExample> implements CmsSystemService {

}
