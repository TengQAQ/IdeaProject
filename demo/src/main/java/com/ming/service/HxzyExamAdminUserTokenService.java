package com.ming.service;

import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.vo.Result;

public interface HxzyExamAdminUserTokenService extends BaseService<Integer, HxzyExamAdminUserToken>{
	Result selectByToken(String token);

	Result logOut(String token);
}
