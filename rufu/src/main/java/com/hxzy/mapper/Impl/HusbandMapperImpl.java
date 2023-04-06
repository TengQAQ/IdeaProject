package com.hxzy.mapper.Impl;

import com.hxzy.entity.Elementary;
import com.hxzy.entity.Husband;
import com.hxzy.mapper.HusbandMapper;
import com.hxzy.util.SessionHelper;

public class HusbandMapperImpl implements HusbandMapper {
	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(Husband record) {
		return 0;
	}

	@Override
	public int insertSelective(Husband record) {
		return 0;
	}

	@Override
	public Husband selectByPrimaryKey(Long id) {
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(HusbandMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Husband record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Husband record) {
		return 0;
	}
}
