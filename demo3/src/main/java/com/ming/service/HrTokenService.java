package com.ming.service;

import com.ming.entity.HrToken;
import com.ming.vo.Result;

public interface HrTokenService extends BaseService<Integer, HrToken>{
	Result selectByToken(String token);

	Result logOut(String token);
}
