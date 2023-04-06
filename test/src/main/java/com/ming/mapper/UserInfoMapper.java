package com.ming.mapper;

import com.ming.entity.UserInfo;
import com.ming.vo.CodeEnum;

/**
* @author QinTeng
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2023-03-30 11:12:48
* @Entity com.ming.entity.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<Integer,UserInfo>{
	UserInfo selectByNickName(String name);
	int logOut(String token);

	UserInfo selectByMobile(String token);

	UserInfo selectByToken(String token);
}
