package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsMenuMapper;
import com.zj.cms.dao.model.CmsMenu;
import com.zj.cms.dao.model.CmsMenuExample;

/**
* 降级实现CmsMenuService接口
* Created by zj on 2019/1/25.
*/
public class CmsMenuServiceMock extends BaseServiceMock<CmsMenuMapper, CmsMenu, CmsMenuExample> implements CmsMenuService {

}
