package com.ming.service.Impl;

import com.ming.entity.UserInfo;
import com.ming.mapper.Impl.UserInfoMapperImpl;
import com.ming.mapper.UserInfoMapper;
import com.ming.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	UserInfoMapper mapper = new UserInfoMapperImpl();
	@Override
	public Long deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Long insert(UserInfo record) {
		return mapper.insert(record);
	}

	@Override
	public Long insertSelective(UserInfo record) {
		return mapper.insertSelective(record);
	}

	@Override
	public UserInfo selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Long updateByPrimaryKeySelective(UserInfo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateByPrimaryKey(UserInfo record) {
		return mapper.updateByPrimaryKey(record);
	}
}
