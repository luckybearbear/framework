package com.zj.upms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.upms.dao.mapper.UpmsSystemMapper;
import com.zj.upms.dao.model.UpmsSystem;
import com.zj.upms.dao.model.UpmsSystemExample;

/**
* 降级实现UpmsSystemService接口
* Created by zj on 2019/1/24.
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

}
