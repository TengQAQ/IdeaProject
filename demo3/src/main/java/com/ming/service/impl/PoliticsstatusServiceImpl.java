package com.ming.service.impl;

import com.ming.entity.Politicsstatus;
import com.ming.mapper.PoliticsstatusMapper;
import com.ming.mapper.impl.PoliticsstatusMapperImpl;
import com.ming.service.PoliticsstatusService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class PoliticsstatusServiceImpl implements PoliticsstatusService {
	private PoliticsstatusMapper mapper = new PoliticsstatusMapperImpl();
	
	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(Politicsstatus record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(Politicsstatus record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		Politicsstatus employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Politicsstatus record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(Politicsstatus record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}


	@Override
	public Result allPoliticsstatus() {
		Result result;
		List<Politicsstatus> politicsstatuses = mapper.allPoliticsstatus();
		if (politicsstatuses.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(politicsstatuses);
		}
		return result;
	}
}
