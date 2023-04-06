package com.hxzy.service;

import com.hxzy.common.dto.back.LoginDto;
import com.hxzy.entity.Emp;

import java.math.BigDecimal;

public interface EmpService extends BaseService<Emp, BigDecimal>{
    Emp login(LoginDto loginDTO);
}
