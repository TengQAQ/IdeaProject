package com.hxzy.mapper.Impl;

import com.hxzy.entity.Elementary;
import com.hxzy.entity.Other;
import com.hxzy.mapper.ElementaryMapper;
import com.hxzy.mapper.OtherMapper;
import com.hxzy.util.SessionHelper;

import java.util.List;

public class OtherMapperImpl implements OtherMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(OtherMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Other record) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(OtherMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Other record) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(OtherMapper.class).insertSelective(record));
	}

	@Override
	public Other selectByPrimaryKey(Integer id) {
		return SessionHelper.query(SqlSession ->SqlSession.getMapper(OtherMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Other record) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(OtherMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Other record) {
		return SessionHelper.dml(SqlSession -> SqlSession.getMapper(OtherMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Other> selectByTable(String tableName) {
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(OtherMapper.class).selectByTable(tableName));
	}
}
