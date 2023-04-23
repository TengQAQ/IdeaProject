package com.hxzy.service.impl;

import com.hxzy.dto.EmployeeSearchDTO;
import com.hxzy.common.dto.back.LoginDto;
import com.hxzy.entity.Emp;
import com.hxzy.mapper.EmpMapper;
import com.hxzy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public List<Emp> search(EmployeeSearchDTO dto) {
        return employeeMapper.search(dto);
    }

	@Override
	public int selectLoginNameCount(String loginName) {
		return this.employeeMapper.selectLoginNameCount(loginName);
	}
}
