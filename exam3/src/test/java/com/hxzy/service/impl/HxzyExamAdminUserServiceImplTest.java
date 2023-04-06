package com.hxzy.service.impl;

import com.hxzy.dto.UserLoginDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class HxzyExamAdminUserServiceImplTest {
    private final HxzyExamAdminUserServiceImpl service =  new HxzyExamAdminUserServiceImpl();
    @Test
    public void login() {
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername("admin");
        userLoginDto.setPassword("654321");
        service.login(userLoginDto);
        System.out.println("登录成功");

    }
}