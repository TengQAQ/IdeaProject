package com.ming.mapper.impl;

import com.ming.entity.Nation;
import com.ming.mapper.NationMapper;
import com.ming.util.SqlSessionHelper;

import java.util.List;

public class NationMapperImpl implements NationMapper {
	@Override
	public int deleteByPrimaryKey(final Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(NationMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Nation record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(NationMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Nation record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(NationMapper.class).insertSelective(record));
	}

	@Override
	public Nation selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(NationMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Nation record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(NationMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Nation record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(NationMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Nation> allNation() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(NationMapper.class).allNation());
	}
}
