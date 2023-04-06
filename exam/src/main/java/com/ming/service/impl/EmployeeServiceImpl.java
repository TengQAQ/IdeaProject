package com.ming.service.impl;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.github.pagehelper.PageInfo;
import com.ming.Dto.EmployeeDto;
import com.ming.Dto.PageDto;
import com.ming.entity.Employee;
import com.ming.mapper.EmployeeMapper;
import com.ming.mapper.impl.EmployeeMapperImpl;
import com.ming.service.EmployeeService;
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
		Employee employee = mapper.selectByPrimaryKey(id);
		Result result = new Result(20000, "查询失败！");
		result.setData(employee);
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
	public Result selectAll(EmployeeDto dto) {
		List<Employee> employees = mapper.selectAll(dto);
		PageInfo pageInfo = PageInfo.of(employees);
		PageVo pageVo = PageVo.of(pageInfo);
		Result result = new Result(20000, "查询失败");
		result.setData(pageVo);
		return result;
	}

	@Override
	public Result toDelete(String[] ints){
		return Result.of(mapper.toDelete(ints),"动态删除失败");
	}
}
