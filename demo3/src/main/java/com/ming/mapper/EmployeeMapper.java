package com.ming.mapper;

import com.ming.dto.EmpDto;
import com.ming.entity.Employee;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【employee(员工信息表)】的数据库操作Mapper
* @createDate 2023-03-24 09:06:41
* @Entity com.ming.entity.Employee
*/
public interface EmployeeMapper extends BaseMapper<Integer,Employee>{
    List<Employee> selectAllEmp(EmpDto dto);

}
