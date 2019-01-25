package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsArticleMapper;
import com.zj.cms.dao.model.CmsArticle;
import com.zj.cms.dao.model.CmsArticleExample;

/**
* 降级实现CmsArticleService接口
* Created by zj on 2019/1/25.
*/
public class CmsArticleServiceMock extends BaseServiceMock<CmsArticleMapper, CmsArticle, CmsArticleExample> implements CmsArticleService {

}
