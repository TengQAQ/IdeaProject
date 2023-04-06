package com.ming.mapper.impl;

import com.github.pagehelper.PageHelper;
import com.ming.Dto.EmployeeDto;
import com.ming.Dto.PageDto;
import com.ming.entity.Employee;
import com.ming.mapper.EmployeeMapper;
import com.ming.util.SessionHelper;

import java.util.List;

public class EmployeeMapperImpl extends SessionHelper implements EmployeeMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Employee record) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Employee record) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).insertSelective(record));
	}

	@Override
	public Employee selectByPrimaryKey(Integer id) {
			return SessionHelper.query(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		return SessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Employee> selectAll(EmployeeDto dto) {
		PageHelper.startPage(dto.getPageNum(),dto.getSize());
		return SessionHelper.query(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).selectAll(dto));
	}

	@Override
	public int toDelete(String[] ints) {
		return SessionHelper.dml(sqlSession ->sqlSession.getMapper(EmployeeMapper.class).toDelete(ints));
	}
}
