package com.ming.mapper.impl;

import com.github.pagehelper.PageHelper;
import com.ming.dto.EmpDto;
import com.ming.entity.Employee;
import com.ming.mapper.EmployeeMapper;
import com.ming.util.SqlSessionHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeMapper {
	@Override
	public int deleteByPrimaryKey(final Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Employee record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Employee record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).insertSelective(record));
	}

	@Override
	public Employee selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Employee> selectAllEmp(EmpDto dto) {
		PageHelper.startPage(dto.getPageNum(),dto.getSize());
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(EmployeeMapper.class).selectAllEmp(dto));
	}
}
