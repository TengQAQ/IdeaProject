package com.ming.mapper;

import com.ming.entity.Department;

/**
* @author QinTeng
* @description 针对表【department】的数据库操作Mapper
* @createDate 2023-03-02 09:55:25
* @Entity com.ming.entity.Department
*/
public interface DepartmentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

}
