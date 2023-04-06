package com.ming.service.impl;

import com.ming.entity.Nation;
import com.ming.mapper.NationMapper;
import com.ming.mapper.impl.NationMapperImpl;
import com.ming.service.NationService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class NationServiceImpl implements NationService {
	private NationMapper mapper = new NationMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(Nation record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(Nation record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		Nation employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Nation record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(Nation record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}


	@Override
	public Result allNation() {
		Result result;
		List<Nation> politicsstatuses = mapper.allNation();
		if (politicsstatuses.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(politicsstatuses);
		}
		return result;
	}
}
