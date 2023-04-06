package com.ming.mapper;

public interface BaseMapper<PK,Model> {
	int deleteByPrimaryKey(PK id);

	int insert(Model record);

	int insertSelective(Model record);

	Model selectByPrimaryKey(PK id);

	int updateByPrimaryKeySelective(Model record);

	int updateByPrimaryKey(Model record);
}
