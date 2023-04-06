package com.ming.mapper;

import com.ming.entity.GoodsInfo;

public interface BaseMapper<PK,Model> {
	PK deleteByPrimaryKey(PK id);

	PK insert(Model record);

	PK insertSelective(Model record);

	Model selectByPrimaryKey(PK id);

	PK updateByPrimaryKeySelective(Model record);

	PK updateByPrimaryKey(Model record);
}
