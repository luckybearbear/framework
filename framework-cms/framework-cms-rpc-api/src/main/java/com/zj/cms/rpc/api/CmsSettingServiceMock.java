package com.zj.cms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.cms.dao.mapper.CmsSettingMapper;
import com.zj.cms.dao.model.CmsSetting;
import com.zj.cms.dao.model.CmsSettingExample;

/**
* 降级实现CmsSettingService接口
* Created by zj on 2019/1/25.
*/
public class CmsSettingServiceMock extends BaseServiceMock<CmsSettingMapper, CmsSetting, CmsSettingExample> implements CmsSettingService {

}
