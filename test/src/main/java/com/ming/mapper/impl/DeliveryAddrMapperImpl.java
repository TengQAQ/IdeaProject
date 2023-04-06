package com.ming.mapper.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.ming.dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.mapper.DeliveryAddrMapper;
import com.ming.util.SqlSessionHelper;

import java.util.List;

public class DeliveryAddrMapperImpl implements DeliveryAddrMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(DeliveryAddr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).insert(record));
	}

	@Override
	public int insertSelective(DeliveryAddr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).insertSelective(record));
	}

	@Override
	public DeliveryAddr selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(DeliveryAddr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(DeliveryAddr record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<DeliveryAddr> selectAll(PageDto pageDto) {
		PageHelper.startPage(pageDto.getPageNum(),pageDto.getSize());
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(DeliveryAddrMapper.class).selectAll(pageDto));
	}
}
