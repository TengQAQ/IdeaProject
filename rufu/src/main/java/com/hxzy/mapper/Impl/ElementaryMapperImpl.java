package com.hxzy.mapper.Impl;

import com.github.pagehelper.PageHelper;
import com.hxzy.Dto.PageDto;
import com.hxzy.Dto.SearchDto;
import com.hxzy.entity.Elementary;
import com.hxzy.mapper.ElementaryMapper;
import com.hxzy.util.SessionHelper;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ElementaryMapperImpl implements ElementaryMapper {
	@Override
	public int deleteByPrimaryKey(String id) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(ElementaryMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(Elementary record) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(ElementaryMapper.class).insert(record));
	}

	@Override
	public int insertSelective(Elementary record) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(ElementaryMapper.class).insertSelective(record));
	}

	@Override
	public Elementary selectByPrimaryKey(String id) {
		return SessionHelper.query(SqlSession ->SqlSession.getMapper(ElementaryMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(Elementary record) {
		return SessionHelper.dml(SqlSession ->SqlSession.getMapper(ElementaryMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(Elementary record) {
		return SessionHelper.dml(SqlSession -> SqlSession.getMapper(ElementaryMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<Elementary> SelectAllElementary(SearchDto dto) {
		PageHelper.startPage(dto.getPageNum(),dto.getSize());
		return SessionHelper.query(SqlSession -> SqlSession.getMapper(ElementaryMapper.class).SelectAllElementary(dto));
	}
}
