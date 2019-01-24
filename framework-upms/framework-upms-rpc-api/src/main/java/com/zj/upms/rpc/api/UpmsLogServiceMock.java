package com.zj.upms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.upms.dao.mapper.UpmsLogMapper;
import com.zj.upms.dao.model.UpmsLog;
import com.zj.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* Created by zj on 2019/1/24.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
