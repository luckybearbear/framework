package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsTopicMapper;
import com.zj.cms.dao.model.CmsTopic;
import com.zj.cms.dao.model.CmsTopicExample;

/**
* 降级实现CmsTopicService接口
* Created by zj on 2019/1/25.
*/
public class CmsTopicServiceMock extends BaseServiceMock<CmsTopicMapper, CmsTopic, CmsTopicExample> implements CmsTopicService {

}
