package com.hxzy.service;

import com.hxzy.entity.UserLogin;
import com.hxzy.vo.Result;

public interface UserLoginService extends BaseService<Integer, UserLogin>{
	Result getUserInfoByToken(String token);
}
