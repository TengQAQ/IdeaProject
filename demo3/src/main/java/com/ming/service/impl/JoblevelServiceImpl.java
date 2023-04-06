package com.ming.service.impl;

import com.ming.entity.Joblevel;
import com.ming.entity.Joblevel;
import com.ming.mapper.JoblevelMapper;
import com.ming.mapper.impl.JoblevelMapperImpl;
import com.ming.service.JoblevelService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class JoblevelServiceImpl implements JoblevelService {
	private JoblevelMapper mapper = new JoblevelMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(Joblevel record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(Joblevel record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		Joblevel employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Joblevel record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(Joblevel record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}


	@Override
	public Result allJoblevel() {
		Result result;
		List<Joblevel> politicsstatuses = mapper.allJoblevel();
		if (politicsstatuses.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(politicsstatuses);
		}
		return result;
	}
}
