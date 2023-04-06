package com.hxzy.mapper.Impl;

import com.hxzy.entity.UserLogin;
import com.hxzy.mapper.UserLoginMapper;
import com.hxzy.util.SessionHelper;

public class UserLoginMapperImpl implements UserLoginMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(UserLogin record) {
		return 0;
	}

	@Override
	public int insertSelective(UserLogin record) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(UserLoginMapper.class).insertSelective(record));
	}

	@Override
	public UserLogin selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserLogin record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserLogin record) {
		return 0;
	}

	@Override
	public UserLogin getUserInfoByToken(String str) {
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(UserLoginMapper.class).getUserInfoByToken(str));
	}
}
