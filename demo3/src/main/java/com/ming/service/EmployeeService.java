package com.ming.service;

import com.ming.dto.EmpDto;
import com.ming.entity.Employee;
import com.ming.vo.Result;

import java.util.List;

public interface EmployeeService extends BaseService<Integer, Employee>{
	Result allEmpInfo(EmpDto dto);
}
