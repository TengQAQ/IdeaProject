package com.ming.services.Impl;

import com.ming.entity.GoodsInfo;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.mapper.Impl.GoodsInfoMapperImpl;
import com.ming.services.GoodsInfoService;

public class GoodsInfoServiceImpl implements GoodsInfoService {
	GoodsInfoMapper goodsmapper= new GoodsInfoMapperImpl();

	@Override
	public Long deleteByPrimaryKey(Long id) {
		return goodsmapper.deleteByPrimaryKey(id);
	}

	@Override
	public Long insert(GoodsInfo record) {
		return goodsmapper.insert(record);
	}

	@Override
	public Long insertSelective(GoodsInfo record) {
		return goodsmapper.insertSelective(record);
	}

	@Override
	public GoodsInfo selectByPrimaryKey(Long id) {
		return goodsmapper.selectByPrimaryKey(id);
	}

	@Override
	public Long updateByPrimaryKeySelective(GoodsInfo record) {
		return goodsmapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateByPrimaryKey(GoodsInfo record) {
		return goodsmapper.updateByPrimaryKey(record);
	}

}
