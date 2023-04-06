package com.hxzy.service;

import com.hxzy.Dto.UserLoginDto;
import com.hxzy.mapper.Impl.RoleMapperImpl;
import com.hxzy.mapper.RoleMapper;
import com.hxzy.vo.Result;

public interface RoleService extends BaseService<Integer, RoleMapper> {
	Result login(UserLoginDto dto);
}
