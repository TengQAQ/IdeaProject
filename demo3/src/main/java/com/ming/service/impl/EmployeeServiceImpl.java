package com.ming.service.impl;

import com.github.pagehelper.PageInfo;
import com.ming.dto.EmpDto;
import com.ming.entity.Employee;
import com.ming.mapper.EmployeeMapper;
import com.ming.mapper.impl.EmployeeMapperImpl;
import com.ming.service.EmployeeService;
import com.ming.vo.CodeEnum;
import com.ming.vo.PageVo;
import com.ming.vo.Result;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeMapper mapper = new EmployeeMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(Employee record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(Employee record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		Employee employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			 result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Employee record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(Employee record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result allEmpInfo(EmpDto dto) {
		Result result;
		List<Employee> employees = mapper.selectAllEmp(dto);
		if (employees == null){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			PageInfo<Employee> pageInfo = PageInfo.of(employees);
			PageVo<Employee> pageVo = PageVo.of(pageInfo);
			System.out.println(pageVo.toString());
			result.setData(pageVo);
		}
		return result;
	}
}
