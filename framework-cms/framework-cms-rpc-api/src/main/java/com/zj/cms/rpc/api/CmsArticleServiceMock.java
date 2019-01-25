package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsArticleMapper;
import com.zj.cms.dao.model.CmsArticle;
import com.zj.cms.dao.model.CmsArticleExample;

import java.util.List;

/**
* 降级实现CmsArticleService接口
* Created by zj on 2019/1/25.
*/
public class CmsArticleServiceMock extends BaseServiceMock<CmsArticleMapper, CmsArticle, CmsArticleExample> implements CmsArticleService {

    @Override
    public List<CmsArticle> selectCmsArticlesByCategoryId(Integer categoryId, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public long countByCategoryId(Integer categoryId) {
        return 0;
    }

    @Override
    public List<CmsArticle> selectCmsArticlesByTagId(Integer tagId, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public long countByTagId(Integer tagId) {
        return 0;
    }
}
