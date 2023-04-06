package com.ming.services;

import com.ming.entity.GoodsInfo;

public interface GoodInfoService {
	int deleteByPrimaryKey(Long id);

	int insert(GoodsInfo record);

	int insertSelective(GoodsInfo record);

	GoodsInfo selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(GoodsInfo record);

	int updateByPrimaryKey(GoodsInfo record);
}
