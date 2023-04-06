package com.ming.mapper.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamGoodsCategory;
import com.ming.mapper.HxzyExamGoodsCategoryMapper;
import com.ming.utils.SqlSessionHelper;

import java.util.List;

public class HxzyExamGoodsCategoryMapperImpl implements HxzyExamGoodsCategoryMapper {
	@Override
	public int deleteByPrimaryKey(Long id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(HxzyExamGoodsCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HxzyExamGoodsCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).insertSelective(record));
	}

	@Override
	public HxzyExamGoodsCategory selectByPrimaryKey(Long id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamGoodsCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(HxzyExamGoodsCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<HxzyExamGoodsCategory> selectAll(PageDto dto) {
//		PageHelper.startPage(dto.getPageNum(),dto.getSize());
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).selectAll(dto));
	}

	@Override
	public int DeleteOneRank(Long id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).DeleteOneRank(id));
	}

	@Override
	public int DeleteTwoRank(Long id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).DeleteTwoRank(id));
	}

	@Override
	public int DeleteThreeRank(Long id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamGoodsCategoryMapper.class).DeleteThreeRank(id));
	}
}
