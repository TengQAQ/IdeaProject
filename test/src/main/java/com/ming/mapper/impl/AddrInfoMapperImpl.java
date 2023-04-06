package com.ming.mapper.impl;

import com.ming.entity.AddrInfo;
import com.ming.mapper.AddrInfoMapper;
import com.ming.util.SqlSessionHelper;
import com.ming.vo.AddrInfoVo;

import java.util.ArrayList;
import java.util.List;

public class AddrInfoMapperImpl implements AddrInfoMapper {
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).deleteByPrimaryKey(id));
	}

	@Override
	public int insert(AddrInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).insert(record));
	}

	@Override
	public int insertSelective(AddrInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).insertSelective(record));
	}

	@Override
	public AddrInfo selectByPrimaryKey(Integer id) {
		return SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).selectByPrimaryKey(id));
	}

	@Override
	public int updateByPrimaryKeySelective(AddrInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).updateByPrimaryKeySelective(record));
	}

	@Override
	public int updateByPrimaryKey(AddrInfo record) {
		return SqlSessionHelper.dml(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).updateByPrimaryKey(record));
	}

	@Override
	public List<AddrInfo> allAddrInfo() {
		List<AddrInfo> addrInfos = SqlSessionHelper.query(sqlSession -> sqlSession.getMapper(AddrInfoMapper.class).allAddrInfo());
		return addrInfos;
	}

	@Override
	public void selectByName(String username) {

	}

}
