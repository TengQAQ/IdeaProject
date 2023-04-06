package com.ming.mapper;

import com.ming.entity.DeptRelation;

/**
* @author QinTeng
* @description 针对表【dept_relation】的数据库操作Mapper
* @createDate 2023-03-02 09:55:25
* @Entity com.ming.entity.DeptRelation
*/
public interface DeptRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DeptRelation record);

    int insertSelective(DeptRelation record);

    DeptRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeptRelation record);

    int updateByPrimaryKey(DeptRelation record);

}
