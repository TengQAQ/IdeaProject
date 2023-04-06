package com.ming.mapper.impl;

import com.ming.entity.Department;
import com.ming.entity.Department;
import com.ming.mapper.DepartmentMapper;
import com.ming.mapper.DepartmentMapper;
import com.ming.util.SqlSessionHelper;

import java.util.List;

public class DepartmentMapperImpl implements DepartmentMapper {
	@Override
	public int deleteByPrimaryKey(final Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Department record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Department record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).insertSelective(record));
	}

	@Override
	public Department selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Department record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Department record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Department> allDepartment() {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).allDepartment());
	}
}
