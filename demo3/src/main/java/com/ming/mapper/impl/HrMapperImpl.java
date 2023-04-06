package com.ming.mapper.impl;

import com.ming.entity.Hr;
import com.ming.entity.Hr;
import com.ming.mapper.HrMapper;
import com.ming.mapper.HrMapper;
import com.ming.util.SqlSessionHelper;

public class HrMapperImpl implements HrMapper {
	@Override
	public int deleteByPrimaryKey(String id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Hr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Hr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrMapper.class).insertSelective(record));
	}

	@Override
	public Hr selectByPrimaryKey(String id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HrMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Hr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Hr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrMapper.class).updateByPrimaryKey(record));
	}
}
