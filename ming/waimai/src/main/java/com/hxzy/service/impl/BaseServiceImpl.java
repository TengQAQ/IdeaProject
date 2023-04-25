package com.hxzy.service.impl;

import com.hxzy.mapper.BaseMapper;
import com.hxzy.service.BaseService;

import java.io.Serializable;

public class BaseServiceImpl<Model, PK extends Serializable> implements BaseService<Model, PK> {
	private BaseMapper mapper;

	public void setMapper(BaseMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int deleteByPrimaryKey(PK id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Model record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Model record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Model selectByPrimaryKey(PK id) {
		return (Model) mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Model record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Model record) {
		return mapper.updateByPrimaryKey(record);
	}
}
