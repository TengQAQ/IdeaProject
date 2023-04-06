package com.hxzy.mapper.Impl;

import com.hxzy.entity.Elementary;
import com.hxzy.entity.Occupation;
import com.hxzy.mapper.OccupationMapper;
import com.hxzy.util.SessionHelper;

import java.util.List;

public class OccupationMapperImpl implements OccupationMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(Occupation record) {
		return 0;
	}

	@Override
	public int insertSelective(Occupation record) {
		return 0;
	}

	@Override
	public Occupation selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Occupation record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Occupation record) {
		return 0;
	}


	@Override
	public List<Occupation> selectAll(String name) {
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(OccupationMapper.class).selectAll(name));
	}
}
