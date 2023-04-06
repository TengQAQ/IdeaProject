package com.ming.mapper.impl;

import com.ming.entity.Organization;
import com.ming.mapper.OrganizationMapper;
import com.ming.util.SessionHelper;

import java.util.List;

public class OrganizationMapperImpl extends SessionHelper implements OrganizationMapper {
	@Override
	public List<Organization> selectAll() {
		return super.query(sqlSession -> sqlSession.getMapper(OrganizationMapper.class).selectAll());
	}

}