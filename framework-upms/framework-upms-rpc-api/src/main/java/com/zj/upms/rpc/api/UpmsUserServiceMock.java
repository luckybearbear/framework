package com.zj.upms.rpc.api;

import com.zj.common.base.BaseServiceMock;
import com.zj.upms.dao.mapper.UpmsUserMapper;
import com.zj.upms.dao.model.UpmsUser;
import com.zj.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by zj on 2019/1/24.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        return null;
    }
}
