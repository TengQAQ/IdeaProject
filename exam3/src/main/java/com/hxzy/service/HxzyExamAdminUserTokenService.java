package com.hxzy.service;

import com.hxzy.entity.HxzyExamAdminUserToken;
import com.hxzy.vo.Result;

public interface HxzyExamAdminUserTokenService extends BaseService<Long, HxzyExamAdminUserToken> {
    Result selectByToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logOut(String token);

}
