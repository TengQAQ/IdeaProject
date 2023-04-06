package com.ming.mapper.impl;

import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.HxzyExamAdminUserTokenMapper;
import com.ming.utils.SqlSessionHelper;
import com.ming.vo.Result;

public class HxzyExamAdminUserTokenMapperImpl implements HxzyExamAdminUserTokenMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(HxzyExamAdminUserToken record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HxzyExamAdminUserToken record) {
		return 0;
	}

	@Override
	public HxzyExamAdminUserToken selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamAdminUserToken record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(HxzyExamAdminUserToken record) {
		return 0;
	}

	@Override
	public HxzyExamAdminUserToken selctByToken(String token) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).selctByToken(token));
	}

	@Override
	public int logOut(String token) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserTokenMapper.class).logOut(token));
	}
}
