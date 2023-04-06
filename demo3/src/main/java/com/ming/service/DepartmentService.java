package com.ming.service;

import com.ming.entity.Department;
import com.ming.vo.Result;

public interface DepartmentService extends BaseService<Integer, Department>{
	Result allDepartment();
}
