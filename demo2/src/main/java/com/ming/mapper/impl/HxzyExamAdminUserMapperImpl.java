package com.ming.mapper.impl;

import com.ming.dto.UserLoginDto;
import com.ming.entity.HxzyExamAdminUser;
import com.ming.mapper.HxzyExamAdminUserMapper;
import com.ming.utils.SqlSessionHelper;

import java.util.List;

public class HxzyExamAdminUserMapperImpl implements HxzyExamAdminUserMapper {
	@Override
	public int deleteByPrimaryKey(String id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(HxzyExamAdminUser record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HxzyExamAdminUser record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).insertSelective(record));
	}

	@Override
	public HxzyExamAdminUser selectByPrimaryKey(String id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamAdminUser record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(HxzyExamAdminUser record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public HxzyExamAdminUser login(String username) {
		HxzyExamAdminUser AdminUser = SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).login(username));
		return AdminUser;
	}
}
