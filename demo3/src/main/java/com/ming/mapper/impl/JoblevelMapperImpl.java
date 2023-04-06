package com.ming.mapper.impl;

import com.ming.entity.Joblevel;
import com.ming.mapper.JoblevelMapper;
import com.ming.mapper.JoblevelMapper;
import com.ming.util.SqlSessionHelper;

import java.util.List;

public class JoblevelMapperImpl implements JoblevelMapper {
	@Override
	public int deleteByPrimaryKey(final Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Joblevel record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Joblevel record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).insertSelective(record));
	}

	@Override
	public Joblevel selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Joblevel record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Joblevel record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Joblevel> allJoblevel() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(JoblevelMapper.class).allJoblevel());
	}
}
