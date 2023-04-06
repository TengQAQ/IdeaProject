package com.ming.mapper;

import com.ming.dto.UserLoginDto;
import com.ming.entity.HxzyExamAdminUser;
import com.ming.vo.Result;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【hxzy_exam_admin_user】的数据库操作Mapper
* @createDate 2023-03-23 18:04:09
* @Entity com.ming.entity.HxzyExamAdminUser
*/
public interface HxzyExamAdminUserMapper extends BaseMapper<String,HxzyExamAdminUser>{
	HxzyExamAdminUser login(String username);

}
