package com.ming.mapper.impl;

import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamCategory;
import com.ming.mapper.HxzyExamCategoryMapper;
import com.ming.utils.SqlSessionHelper;
import com.ming.vo.CategoryVo;
import com.ming.vo.Result;

import java.util.List;

public class HxzyExamCategoryMapperImpl implements HxzyExamCategoryMapper {
	@Override
	public int deleteByPrimaryKey(Long id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(HxzyExamCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).insert(record));
	}

	@Override
	public int insertSelective(HxzyExamCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).insertSelective(record));
	}

	@Override
	public HxzyExamCategory selectByPrimaryKey(Long id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(HxzyExamCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(HxzyExamCategory record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<HxzyExamCategory> selectAll() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).selectAll());
	}

	@Override
	public List<CategoryVo> getCategory() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).getCategory());
	}

	@Override
	public HxzyExamCategory gradeJudgment(Long paramId) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).gradeJudgment(paramId));
	}

	@Override
	public int BashDelCate(List list) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(HxzyExamCategoryMapper.class).BashDelCate(list));
	}
}
