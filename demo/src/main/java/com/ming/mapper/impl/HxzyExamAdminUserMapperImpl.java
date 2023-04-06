package com.ming.mapper.impl;

import com.ming.entity.HxzyExamAdminUser;
import com.ming.mapper.HxzyExamAdminUserMapper;
import com.ming.utils.SqlSessionHelper;

public class HxzyExamAdminUserMapperImpl implements HxzyExamAdminUserMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(HxzyExamAdminUser record) {
		return 0;
	}

	@Override
	public int insertSelective(HxzyExamAdminUser record) {
		return 0;
	}

	@Override
	public HxzyExamAdminUser selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamAdminUser record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(HxzyExamAdminUser record) {
		return 0;
	}


	public HxzyExamAdminUser selectByUserName(String name) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamAdminUserMapper.class).selectByUserName(name));
	}
}
