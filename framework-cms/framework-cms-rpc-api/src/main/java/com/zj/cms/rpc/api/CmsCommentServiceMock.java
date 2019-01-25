package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsCommentMapper;
import com.zj.cms.dao.model.CmsComment;
import com.zj.cms.dao.model.CmsCommentExample;

/**
* 降级实现CmsCommentService接口
* Created by zj on 2019/1/25.
*/
public class CmsCommentServiceMock extends BaseServiceMock<CmsCommentMapper, CmsComment, CmsCommentExample> implements CmsCommentService {

}
