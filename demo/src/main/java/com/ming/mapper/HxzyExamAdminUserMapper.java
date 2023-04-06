package com.ming.mapper;

import com.ming.entity.HxzyExamAdminUser;

/**
* @author QinTeng
* @description 针对表【hxzy_exam_admin_user】的数据库操作Mapper
* @createDate 2023-03-13 12:23:49
* @Entity com.ming.entity.HxzyExamAdminUser
*/
public interface HxzyExamAdminUserMapper extends BaseMapper<Integer,HxzyExamAdminUser>{
	HxzyExamAdminUser selectByUserName(String name);

}
