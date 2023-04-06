package com.ming.service.impl;

import com.ming.entity.Organization;
import com.ming.mapper.OrganizationMapper;
import com.ming.mapper.impl.OrganizationMapperImpl;
import com.ming.service.BaseService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class OrganizationServiceImpl implements OrganizationService, BaseService<Integer, Organization> {
	// 调用数据访问层
	private final OrganizationMapper mapper = new OrganizationMapperImpl();
	@Override
	public Result selectAll() {
		List<Organization> organizations = mapper.selectAll();
		Result of = Result.of(CodeEnum.SUCCESS);
		of.setData(organizations);
		return of;
	}

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result insert(Organization record) {
		return null;
	}

	@Override
	public Result insertSelective(Organization record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result updateByPrimaryKeySelective(Organization record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(Organization record) {
		return null;
	}
}