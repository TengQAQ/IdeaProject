package com.ming.mapper.impl;

import com.ming.entity.UserInfo;
import com.ming.mapper.UserInfoMapper;
import com.ming.util.SqlSessionHelper;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

public class UserInfoMapperImpl implements UserInfoMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(UserInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).insert(record));
	}

	@Override
	public int insertSelective(UserInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).insertSelective(record));
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public UserInfo selectByNickName(String name) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).selectByNickName(name));
	}

	@Override
	public int logOut(String token) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).logOut(token));
	}

	@Override
	public UserInfo selectByMobile(String token) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).selectByToken(token));
	}

	@Override
	public UserInfo selectByToken(String token) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(UserInfoMapper.class).selectByToken(token));
	}
}
