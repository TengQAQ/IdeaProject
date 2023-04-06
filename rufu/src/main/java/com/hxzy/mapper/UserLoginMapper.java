package com.hxzy.mapper;

import com.hxzy.entity.UserLogin;

/**
* @author QinTeng
* @description 针对表【user login】的数据库操作Mapper
* @createDate 2023-03-13 20:03:27
* @Entity com.hxzy.entity.Userlogin
*/
public interface UserLoginMapper extends BaseMapper<Integer,UserLogin>{
	UserLogin getUserInfoByToken(String str);
}
