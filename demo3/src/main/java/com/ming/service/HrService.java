package com.ming.service;

import com.ming.dto.UserLoginDto;
import com.ming.entity.Hr;
import com.ming.vo.Result;

public interface HrService extends BaseService<String, Hr>{

	Result login(UserLoginDto dto);
}
