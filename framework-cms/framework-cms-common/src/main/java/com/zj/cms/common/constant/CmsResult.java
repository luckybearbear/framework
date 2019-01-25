package com.zj.cms.common.constant;

import com.zj.common.base.BaseResult;

/**
 * cms系统常量枚举类
 * Created by zj
 */
public class CmsResult extends BaseResult {

    public CmsResult(CmsResultConstant cmsResultConstant, Object data) {
        super(cmsResultConstant.getCode(), cmsResultConstant.getMessage(), data);
    }

}
