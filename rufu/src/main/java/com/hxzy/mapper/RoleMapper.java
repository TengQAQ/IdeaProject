package com.hxzy.mapper;

import com.hxzy.Dto.UserLoginDto;
import com.hxzy.entity.Role;

/**
* @author QinTeng
* @description 针对表【role(管理员表)】的数据库操作Mapper
* @createDate 2023-03-06 14:18:06
* @Entity com.hxzy.entity.Role
*/
public interface RoleMapper extends BaseMapper<Integer,Role>{

	Role selectByNumber(String dto);
}
