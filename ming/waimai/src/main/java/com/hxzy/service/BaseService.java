package com.hxzy.service;

import java.io.Serializable;

public interface BaseService<Model,PK extends Serializable> {
	int deleteByPrimaryKey(PK id);

	int insert(Model record);

	int insertSelective(Model record);

	Model selectByPrimaryKey(PK id);

	int updateByPrimaryKeySelective(Model record);

	int updateByPrimaryKey(Model record);
}
