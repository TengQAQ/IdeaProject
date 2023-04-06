package com.ming.service.impl;

import com.ming.entity.Employee;
import com.ming.service.EmployeeService;
import com.ming.vo.Result;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
public class EmployeeServiceImplTest {
	private EmployeeService service = new EmployeeServiceImpl();

	@Test
	public void deleteByPrimaryKey() {
	}

	@Test
	public void insert() {
	}

	@Test
	public void insertSelective() {
		Employee employee = new Employee();
		employee.setName("秦明");
		employee.setGender("男");
		employee.setBirthday(new Date(System.currentTimeMillis()));
		employee.setIdcard("5001012001");
		Result result = service.insertSelective(employee);
		System.out.println(result);
	}

	@Test
	public void selectByPrimaryKey() {
	}

	@Test
	public void updateByPrimaryKeySelective() {
	}

	@Test
	public void updateByPrimaryKey() {
	}

	@Test
	public void allEmpInfo() {
	}
}