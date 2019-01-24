package com.zj.upms.rpc.api;

import com.zheng.common.base.BaseServiceMock;
import com.zj.upms.dao.mapper.UpmsUserMapper;
import com.zj.upms.dao.model.UpmsUser;
import com.zj.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by shuzheng on 2019/1/24.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
