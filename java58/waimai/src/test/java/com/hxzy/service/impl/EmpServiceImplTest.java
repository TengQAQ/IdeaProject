package com.hxzy.service.impl;

import com.hxzy.entity.Emp;
import com.hxzy.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpServiceImplTest {

	@Autowired
	private EmpService employeeService;

	@Test
	void contextLoads() {
	}


	/**
	 * 向数据库中新增员工信息
	 */
	@Test
	public void addEmployee(){
		Emp employee=new Emp();
		employee.setLoginName("admin");
		employee.setGender((short) 1);
		employee.setLoginPwd("admin8888");
		employee.setStatus((short) 0);
		employee.setAvatar("https://plus.hutool.cn/images/ad/ccflow2.png");
		employee.setCreateBy("admin");
		employee.setCreateTime(new Date());

		int insert = this.employeeService.insert(employee);
		System.out.println(insert);
//		Assert.equals(1, insert);

	}

}