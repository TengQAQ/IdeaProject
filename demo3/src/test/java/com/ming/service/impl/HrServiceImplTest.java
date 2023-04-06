package com.ming.service.impl;

import com.ming.dto.UserLoginDto;
import com.ming.service.HrService;
import org.junit.Test;

import static org.junit.Assert.*;

public class HrServiceImplTest {
private final HrService service = new HrServiceImpl();
	@Test
	public void login() {
		UserLoginDto userLoginDto = new UserLoginDto();
		userLoginDto.setUsername("admin");
		userLoginDto.setPassword("654321");
		service.login(userLoginDto);
	}
}