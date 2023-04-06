package com.hxzy.service.impl;

import com.hxzy.common.dto.back.LoginDto;
import com.hxzy.entity.Emp;
import com.hxzy.mapper.EmpMapper;
import com.hxzy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp,BigDecimal> implements EmpService{
	private EmpMapper employeeMapper;

	@Autowired
	public void setEmployeeMapper(EmpMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
		super.setMapper(employeeMapper);
	}

	@Override
	public Emp login(LoginDto loginDTO) {
		return employeeMapper.selectByUserName(loginDTO.getLoginName());
	}
}
