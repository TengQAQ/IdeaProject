package com.ming.mapper.Impl;

import com.ming.entity.DeliveryAddr;
import com.ming.entity.UserInfo;
import com.ming.mapper.UserInfoMapper;
import com.ming.utils.SqlSessionHelper;

import java.util.List;

public class UserInfoMapperImpl extends SqlSessionHelper implements UserInfoMapper {
	@Override
	public Long deleteByPrimaryKey(Long id) {
		return SqlSessionHelper.opensqlsession().getMapper(UserInfoMapper.class).deleteByPrimaryKey(id);
	}

	@Override
	public Long insert(UserInfo record) {
		return SqlSessionHelper.opensqlsession().getMapper(UserInfoMapper.class).insert(record);
	}

	@Override
	public Long insertSelective(UserInfo record) {
		return SqlSessionHelper.opensqlsession().getMapper(UserInfoMapper.class).insertSelective(record);
	}

	@Override
	public UserInfo selectByPrimaryKey(Long id) {
		return SqlSessionHelper.opensqlsession().getMapper(UserInfoMapper.class).selectByPrimaryKey(id);
	}

	@Override
	public Long updateByPrimaryKeySelective(UserInfo record) {
		return SqlSessionHelper.opensqlsession().getMapper(UserInfoMapper.class).updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateByPrimaryKey(UserInfo record) {
		return SqlSessionHelper.opensqlsession().getMapper(UserInfoMapper.class).updateByPrimaryKey(record);
	}

}
