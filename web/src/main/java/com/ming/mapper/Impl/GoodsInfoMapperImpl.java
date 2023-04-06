package com.ming.mapper.Impl;

import com.github.pagehelper.PageHelper;
import com.ming.Dto.PageDto;
import com.ming.entity.GoodsInfo;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.utils.SessionHelper;

import java.util.List;

public class GoodsInfoMapperImpl extends SessionHelper implements GoodsInfoMapper {
	@Override
	public Integer deleteByPrimaryKey(Integer id) {
		return dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public Integer insert(GoodsInfo record) {
		return dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).insert(record));
	}

	@Override
	public Integer insertSelective(GoodsInfo record) {
		return dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).insertSelective(record));
	}

	@Override
	public GoodsInfo selectByPrimaryKey(Integer id) {
		return query(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public Integer updateByPrimaryKeySelective(GoodsInfo record) {
		return dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public Integer updateByPrimaryKey(GoodsInfo record) {
		return dml(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<GoodsInfo> SelectAllGoodsInfo(PageDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getSize());
		return super.query(sqlSession -> sqlSession.getMapper(GoodsInfoMapper.class).SelectAllGoodsInfo(dto));
	}
}
