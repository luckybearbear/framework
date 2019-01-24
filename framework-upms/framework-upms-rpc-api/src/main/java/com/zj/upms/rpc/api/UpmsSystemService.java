package com.zj.upms.rpc.api;

import com.zj.common.base.BaseService;
import com.zj.upms.dao.model.UpmsSystem;
import com.zj.upms.dao.model.UpmsSystemExample;

/**
* UpmsSystemService接口
* Created by zj on 2019/1/24.
*/
public interface UpmsSystemService extends BaseService<UpmsSystem, UpmsSystemExample> {
    /**
     * 根据name获取UpmsSystem
     * @param name
     * @return
     */
    UpmsSystem selectUpmsSystemByName(String name);

}