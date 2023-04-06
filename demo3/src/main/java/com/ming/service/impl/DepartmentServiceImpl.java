package com.ming.service.impl;

import com.ming.entity.Department;
import com.ming.mapper.DepartmentMapper;
import com.ming.mapper.impl.DepartmentMapperImpl;
import com.ming.service.DepartmentService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentMapper mapper = new DepartmentMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(Department record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(Department record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		Department employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Department record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(Department record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}


	@Override
	public Result allDepartment() {
		Result result;
		List<Department> politicsstatuses = mapper.allDepartment();
		if (politicsstatuses.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(politicsstatuses);
		}
		return result;
	}
}
