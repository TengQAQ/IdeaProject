package com.ming.service.Impl;

import com.ming.Dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.entity.UserInfo;
import com.ming.service.DeliveryAddrService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryAddrServiceImplTest {
	DeliveryAddrService service = new DeliveryAddrServiceImpl();

	@Test
	public void deleteByPrimaryKey() {
	}

	@Test
	public void insert() {
	}

	@Test
	public void insertSelective() {
		DeliveryAddr deliveryAddr = new DeliveryAddr();
		UserInfo u = new UserInfo();
		 u.setId(12);
		deliveryAddr.setUserInfo(u);
		deliveryAddr.setContactsName("黎协");
		deliveryAddr.setContactsTel("110");
		deliveryAddr.setAddr("石马河派出所");
		deliveryAddr.setIsDefault("0");
		System.out.println(service.insertSelective(deliveryAddr));
	}

	@Test
	public void selectByPrimaryKey() {
		DeliveryAddr deliveryAddr = service.selectByPrimaryKey(1L);
		System.out.println(deliveryAddr);
	}

	@Test
	public void updateByPrimaryKeySelective() {
	}

	@Test
	public void updateByPrimaryKey() {
	}

	@Test
	public void selectAll() {
		PageDto dto = new PageDto();
		dto.setPageNum(1);
		dto.setSize(5);
		List<DeliveryAddr> deliveryAddrs = service.selectAll(dto);
//		System.out.println(deliveryAddrs);
	}

	@Test
	public void deletebatch() {
		List<Long> interger = Arrays.asList(10L,13L);
		int deletebatch = this.service.deletebatch(interger);
		System.out.println(deletebatch);
	}
}