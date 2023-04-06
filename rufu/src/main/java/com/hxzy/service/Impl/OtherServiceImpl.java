package com.hxzy.service.Impl;

import com.hxzy.entity.Other;
import com.hxzy.mapper.Impl.OtherMapperImpl;
import com.hxzy.mapper.OtherMapper;
import com.hxzy.service.OtherService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

import java.util.List;

public class OtherServiceImpl implements OtherService {
	private OtherMapper mapper =new OtherMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Object id) {
		return null;
	}

	@Override
	public Result insert(Object record) {
		return null;
	}

	@Override
	public Result insertSelective(Object record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Object id) {
		return null;
	}

	@Override
	public Result updateByPrimaryKeySelective(Object record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(Object record) {
		return null;
	}

	@Override
	public Result selectByTable(String tableName) {
		List<Other> otherList = mapper.selectByTable(tableName);
		Result result = Result.of(CodeEnum.SUCCESS);
		result.setData(otherList);
		return result;
	}
}
