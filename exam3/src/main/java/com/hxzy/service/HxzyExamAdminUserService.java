package com.hxzy.service;

import com.hxzy.dto.UserLoginDto;
import com.hxzy.entity.HxzyExamAdminUser;
import com.hxzy.vo.Result;

public interface HxzyExamAdminUserService extends BaseService<Long, HxzyExamAdminUser>{
    Result login(UserLoginDto dto);
}
