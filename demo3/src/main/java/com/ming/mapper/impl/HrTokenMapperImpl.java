package com.ming.mapper.impl;

import com.ming.entity.HrToken;
import com.ming.mapper.HrTokenMapper;
import com.ming.util.SqlSessionHelper;

import java.util.List;

public class HrTokenMapperImpl implements HrTokenMapper {
	@Override
	public int deleteByPrimaryKey(final Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(HrToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HrToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).insertSelective(record));
	}

	@Override
	public HrToken selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(HrToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(HrToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public HrToken selectByToken(String token) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).selectByToken(token));
	}

	@Override
	public int logOut(String token) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HrTokenMapper.class).logOut(token));
	}
}
