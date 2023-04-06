package com.ming.mapper;

import com.ming.entity.Department;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【department(部门表)】的数据库操作Mapper
* @createDate 2023-03-24 14:07:21
* @Entity com.ming.entity.Department
*/
public interface DepartmentMapper extends BaseMapper<Integer,Department>{


	List<Department> allDepartment();
}
