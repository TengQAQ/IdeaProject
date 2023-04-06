package com.ming.services.Impl;

import com.ming.entity.GoodsInfo;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.mapper.Impl.GoodsInfoMapperImpl;
import com.ming.services.GoodInfoService;

public class GoodsInfoServiceImpl implements GoodInfoService {
	private final GoodsInfoMapper goodsInfoMapper = new GoodsInfoMapperImpl();
	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(GoodsInfo record) {
		return goodsInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(GoodsInfo record) {
		return 0;
	}

	@Override
	public GoodsInfo selectByPrimaryKey(Long id) {
		return goodsInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsInfo record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(GoodsInfo record) {
		return 0;
	}
}
