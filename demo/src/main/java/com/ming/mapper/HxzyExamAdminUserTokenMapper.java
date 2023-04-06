package com.ming.mapper;

import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.vo.Result;

/**
* @author QinTeng
* @description 针对表【hxzy_exam_admin_user_token】的数据库操作Mapper
* @createDate 2023-03-13 12:23:49
* @Entity com.ming.entity.HxzyExamAdminUserToken
*/
public interface HxzyExamAdminUserTokenMapper extends BaseMapper<Integer, HxzyExamAdminUserToken>{
	HxzyExamAdminUserToken selctByToken(String token);

	int logOut(String token);
}
