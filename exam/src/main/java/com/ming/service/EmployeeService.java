package com.ming.service;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.ming.Dto.EmployeeDto;
import com.ming.Dto.PageDto;
import com.ming.entity.Employee;
import com.ming.vo.Result;

public interface EmployeeService extends BaseService<Integer, Employee>{
	Result selectAll(EmployeeDto dto);

	Result toDelete(String[] ids);
}
