package com.ming.service;

import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.BaseMapper;
import com.ming.mapper.HxzyExamAdminUserTokenMapper;
import com.ming.vo.Result;

public interface HxzyExamAdminUserTokenService extends BaseService<Long, HxzyExamAdminUserToken> {
	Result selectByToken(String token);

	Result logOut(String token);
}
