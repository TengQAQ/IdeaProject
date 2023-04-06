package com.ming.mapper;

import com.ming.Dto.EmployeeDto;
import com.ming.Dto.PageDto;
import com.ming.entity.Employee;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2023-02-27 18:51:13
* @Entity com.ming.entity.Employee
*/
public interface EmployeeMapper extends BaseMapper<Integer,Employee>{
	List<Employee> selectAll(EmployeeDto dto);

	int toDelete(String[] ints);
}
