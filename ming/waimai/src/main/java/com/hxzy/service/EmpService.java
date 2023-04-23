package com.hxzy.service;

import com.hxzy.dto.EmployeeSearchDTO;
import com.hxzy.common.dto.back.LoginDto;
import com.hxzy.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmpService extends BaseService<Emp, BigDecimal>{
    Emp login(LoginDto loginDTO);

    List<Emp> search(@Param("dto") EmployeeSearchDTO dto);

    int selectLoginNameCount(String loginName);
}
