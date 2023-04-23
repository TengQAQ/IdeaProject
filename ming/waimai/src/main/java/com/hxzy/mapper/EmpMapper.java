package com.hxzy.mapper;

import com.hxzy.dto.EmployeeSearchDTO;
import com.hxzy.entity.Emp;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper extends BaseMapper<Emp,BigDecimal>{
    Emp selectByUserName(String name);

    List<Emp> search(@Param("dto") EmployeeSearchDTO dto);

    /**
     * 查询用户名是否被使用
     * @param loginName
     * @return
     */
    @Select(value = "select count(*) from EMPLOYEE where LOGIN_NAME=#{loginName}")
    int selectLoginNameCount(String loginName);
}