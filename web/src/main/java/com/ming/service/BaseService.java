package com.ming.service;

import com.ming.vo.Result;

public interface BaseService<PK,Model> {

	PK deleteByPrimaryKey(PK id);

	PK insert(Model record);

	PK insertSelective(Model record);

	Model selectByPrimaryKey(PK id);

	PK updateByPrimaryKeySelective(Model record);

	PK updateByPrimaryKey(Model record);
}