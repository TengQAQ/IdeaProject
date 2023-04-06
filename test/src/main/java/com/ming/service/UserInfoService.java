package com.ming.service;

import com.ming.dto.UserLoginDto;
import com.ming.entity.UserInfo;
import com.ming.vo.Result;

public interface UserInfoService extends BaseService<Integer, UserInfo>{
	Result logOut(String token);
	Result selectByNickName(String name);

	Result selectByToken(String token);

	Result login(UserLoginDto dto);
}
