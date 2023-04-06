package com.ming.mapper.impl;

import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.HxzyExamAdminUserTokenMapper;
import com.ming.utils.SqlSessionHelper;

public class HxzyExamAdminUserTokenMapperImpl implements HxzyExamAdminUserTokenMapper {
	@Override
	public int deleteByPrimaryKey(Long id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(HxzyExamAdminUserToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HxzyExamAdminUserToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).insertSelective(record));
	}

	@Override
	public HxzyExamAdminUserToken selectByPrimaryKey(Long id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamAdminUserToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(HxzyExamAdminUserToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public HxzyExamAdminUserToken selectByToken(String token) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).selectByToken(token));
	}

	@Override
	public int logOut(String token) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).logOut(token));
	}
}
