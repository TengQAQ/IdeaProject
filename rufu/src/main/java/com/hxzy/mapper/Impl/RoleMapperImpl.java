package com.hxzy.mapper.Impl;

import com.hxzy.Dto.UserLoginDto;
import com.hxzy.entity.Role;
import com.hxzy.mapper.RoleMapper;
import com.hxzy.util.SessionHelper;
import org.apache.ibatis.session.SqlSession;

public class RoleMapperImpl implements RoleMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(RoleMapperImpl.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Role record) {
		return 0;
	}

	@Override
	public int insertSelective(Role record) {
		return 0;
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(RoleMapperImpl.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return 0;
	}

	@Override
	public Role selectByNumber(String dto) {
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(RoleMapper.class).selectByNumber(dto));
	}
}
