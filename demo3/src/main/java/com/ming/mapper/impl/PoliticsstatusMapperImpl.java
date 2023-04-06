package com.ming.mapper.impl;

import com.ming.entity.Politicsstatus;
import com.ming.entity.Politicsstatus;
import com.ming.mapper.PoliticsstatusMapper;
import com.ming.mapper.PoliticsstatusMapper;
import com.ming.util.SqlSessionHelper;

import java.util.List;

public class PoliticsstatusMapperImpl implements PoliticsstatusMapper {
	@Override
	public int deleteByPrimaryKey(final Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Politicsstatus record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Politicsstatus record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).insertSelective(record));
	}

	@Override
	public Politicsstatus selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Politicsstatus record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Politicsstatus record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Politicsstatus> allPoliticsstatus() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(PoliticsstatusMapper.class).allPoliticsstatus());
	}
}
