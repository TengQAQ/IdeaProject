package com.ming.services.Impl;

import com.ming.entity.GoodsInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsInfoServiceImplTest {
	GoodsInfoServiceImpl goodsInfoService =new GoodsInfoServiceImpl();

	@Test
	public void deleteByPrimaryKey() {
	}

	@Test
	public void insert() {
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setGoodsName("安慕希");

		goodsInfoService.insert(goodsInfo);
	}

	@Test
	public void insertSelective() {
	}

	@Test
	public void selectByPrimaryKey() {
		GoodsInfo goodsInfo = goodsInfoService.selectByPrimaryKey(5L);
		System.out.println(goodsInfo);
	}

	@Test
	public void updateByPrimaryKeySelective() {
	}

	@Test
	public void updateByPrimaryKey() {
	}
}