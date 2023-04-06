package com.ming.service.Impl;

import com.ming.Dto.PageDto;
import com.ming.service.GoodsInfoService;
import com.ming.vo.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsInfoServiceImplTest {
	private GoodsInfoService service =new GoodsInfoServiceImpl();

	@Test
	public void deleteByPrimaryKey() {
	}

	@Test
	public void insert() {
	}

	@Test
	public void insertSelective() {
	}

	@Test
	public void selectByPrimaryKey() {
		Result res = service.selectByPrimaryKey(10);
		System.out.println(res.toString());
	}

	@Test
	public void updateByPrimaryKeySelective() {
	}

	@Test
	public void updateByPrimaryKey() {
	}

	@Test
	public void selectAll() {
		Result result = service.selectAll(new PageDto());
		System.out.println(result.toString());
	}

	@Test
	public void testDeleteByPrimaryKey() {
	}

	@Test
	public void testInsert() {
	}

	@Test
	public void testInsertSelective() {
	}

	@Test
	public void testSelectByPrimaryKey() {
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
	}

	@Test
	public void testUpdateByPrimaryKey() {
	}

	@Test
	public void testSelectAll() {
	}
}