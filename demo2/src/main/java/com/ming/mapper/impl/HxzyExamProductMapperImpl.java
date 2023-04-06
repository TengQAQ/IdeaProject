package com.ming.mapper.impl;

import com.ming.entity.HxzyExamProduct;
import com.ming.mapper.HxzyExamProductMapper;
import com.ming.utils.SqlSessionHelper;

import java.util.List;

public class HxzyExamProductMapperImpl implements HxzyExamProductMapper {
	@Override
	public int deleteByPrimaryKey(String id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(HxzyExamProduct record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HxzyExamProduct record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).insertSelective(record));
	}

	@Override
	public HxzyExamProduct selectByPrimaryKey(String id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamProduct record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(HxzyExamProduct record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<HxzyExamProduct> selectAll() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamProductMapper.class).selectAll());
	}
}
