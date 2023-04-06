package com.ming.mapper;

import com.ming.entity.HxzyExamAdminUser;

public interface BaseMapper<PK,Model> {
	int deleteByPrimaryKey(PK id);

	int insert(Model record);

	int insertSelective(Model record);

	Model selectByPrimaryKey(PK id);

	int updateByPrimaryKeySelective(Model record);

	int updateByPrimaryKey(Model record);
}
