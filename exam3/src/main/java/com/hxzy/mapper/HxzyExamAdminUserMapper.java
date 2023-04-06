package com.hxzy.mapper;

import com.hxzy.entity.HxzyExamAdminUser;

/**
* @author Administrator
* @description 针对表【hxzy_exam_admin_user】的数据库操作Mapper
* @createDate 2023-03-13 09:46:35
* @Entity com.hxzy.entity.HxzyExamAdminUser
*/
public interface HxzyExamAdminUserMapper extends BaseMapper<Long,HxzyExamAdminUser> {
    HxzyExamAdminUser selectByUserName(String userName);



}
