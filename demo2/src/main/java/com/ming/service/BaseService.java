package com.ming.service;

import com.ming.vo.Result;

public interface BaseService<PK,Model> {
	Result deleteByPrimaryKey(PK id);

	Result insert(Model record);

	Result insertSelective(Model record);

	Result selectByPrimaryKey(PK id);

	Result updateByPrimaryKeySelective(Model record);

	Result updateByPrimaryKey(Model record);
}
