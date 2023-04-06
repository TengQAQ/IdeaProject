package com.ming.service.Impl;

import com.ming.entity.UserInfo;
import com.ming.service.UserInfoService;

import java.util.Date;

import static org.junit.Assert.*;
public class UserInfoServiceImplTest {
	UserInfoService service = new UserInfoServiceImpl();

	@org.junit.Test
	public void deleteByPrimaryKey() {
		service.deleteByPrimaryKey(33L);
	}

	@org.junit.Test
	public void insert() {
		UserInfo userInfo = new UserInfo();
		userInfo.setRegTime(new Date(System.currentTimeMillis()));
		userInfo.setUserPoint(10);
		service.insert(userInfo);
	}

	@org.junit.Test
	public void insertSelective() {

	}

	@org.junit.Test
	public void selectByPrimaryKey() {
//		UserInfoService userInfoService = new UserInfoServiceImpl();
		service.selectByPrimaryKey(1L);
	}

	@org.junit.Test
	public void updateByPrimaryKeySelective() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(33);
		userInfo.setRegTime(new Date(System.currentTimeMillis() - 10000));
		userInfo.setUserPoint(8);
		userInfo.setMobile("17623876031");
		service.updateByPrimaryKeySelective(userInfo);
	}

	@org.junit.Test
	public void updateByPrimaryKey() {
	}
}