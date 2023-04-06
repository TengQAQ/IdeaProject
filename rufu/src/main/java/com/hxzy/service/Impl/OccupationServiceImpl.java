package com.hxzy.service.Impl;

import com.hxzy.entity.Occupation;
import com.hxzy.mapper.Impl.OccupationMapperImpl;
import com.hxzy.mapper.OccupationMapper;
import com.hxzy.service.OccupationService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

import java.util.List;

public class OccupationServiceImpl implements OccupationService {
	private OccupationMapper mapper =new OccupationMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result insert(Occupation record) {
		return null;
	}

	@Override
	public Result insertSelective(Occupation record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result updateByPrimaryKeySelective(Occupation record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(Occupation record) {
		return null;
	}

	@Override
	public Result selectAll(String name) {
		List<Occupation> i = mapper.selectAll(name);
		Result result = Result.of(CodeEnum.SUCCESS);
		result.setData(i);
		return result;
	}
}
