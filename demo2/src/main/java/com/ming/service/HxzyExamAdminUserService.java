package com.ming.service;

import com.ming.dto.UserLoginDto;
import com.ming.entity.HxzyExamAdminUser;
import com.ming.vo.Result;

public interface HxzyExamAdminUserService extends BaseService<String, HxzyExamAdminUser>{
	Result login(UserLoginDto dto);
}
