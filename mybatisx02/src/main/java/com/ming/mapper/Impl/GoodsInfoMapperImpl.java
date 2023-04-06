package com.ming.mapper.Impl;

import com.ming.entity.GoodsInfo;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.utils.SqlsessionHelper;

public class GoodsInfoMapperImpl implements GoodsInfoMapper {
	@Override
	public Long deleteByPrimaryKey(Long id) {
		return SqlsessionHelper.opensqlsession().getMapper(GoodsInfoMapper.class).deleteByPrimaryKey(id);
	}

	@Override
	public Long insert(GoodsInfo record) {
		return SqlsessionHelper.opensqlsession().getMapper(GoodsInfoMapper.class).insert(record);
	}

	@Override
	public Long insertSelective(GoodsInfo record) {
		return SqlsessionHelper.opensqlsession().getMapper(GoodsInfoMapper.class).insertSelective(record);
	}

	@Override
	public GoodsInfo selectByPrimaryKey(Long id) {
		return SqlsessionHelper.opensqlsession().getMapper(GoodsInfoMapper.class).selectByPrimaryKey(id);
	}

	@Override
	public Long updateByPrimaryKeySelective(GoodsInfo record) {
		return SqlsessionHelper.opensqlsession().getMapper(GoodsInfoMapper.class).updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateByPrimaryKey(GoodsInfo record) {
		return SqlsessionHelper.opensqlsession().getMapper(GoodsInfoMapper.class).updateByPrimaryKey(record);
	}
}
