package com.ming.service;

import com.ming.entity.UserInfo;

public interface UserInfoService extends BaseService<Long, UserInfo>{
	@Override
	Long deleteByPrimaryKey(Long id);

	@Override
	Long insert(UserInfo record);

	@Override
	Long insertSelective(UserInfo record);

	@Override
	UserInfo selectByPrimaryKey(Long id);

	@Override
	Long updateByPrimaryKeySelective(UserInfo record);

	@Override
	Long updateByPrimaryKey(UserInfo record);
}
