package com.ming.mapper.impl;

import com.ming.entity.HrToken;
import com.ming.mapper.HrTokenMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class HrTokenMapperImplTest {
	private final HrTokenMapper mapper = new HrTokenMapperImpl();

	@Test
	public void insertSelective() {
		HrToken hrToken = new HrToken();
		hrToken.setHrId(new Long(3));
		hrToken.setToken("111");
		mapper.insertSelective(hrToken);
	}

	@Test
	public void updateByPrimaryKeySelective() {
//		HrToken hrToken = new HrToken();
//		hrToken.setHrId(new Long(3));
//		hrToken.setToken("111");
//		mapper.updateByPrimaryKeySelective(hrToken);
		mapper.selectByPrimaryKey(3);
	}
}