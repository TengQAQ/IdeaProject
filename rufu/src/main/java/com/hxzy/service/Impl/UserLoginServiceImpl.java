package com.hxzy.service.Impl;

import com.hxzy.entity.UserLogin;
import com.hxzy.mapper.Impl.UserLoginMapperImpl;
import com.hxzy.mapper.UserLoginMapper;
import com.hxzy.service.UserLoginService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

import java.util.HashMap;
import java.util.Map;

public class UserLoginServiceImpl implements UserLoginService {
	private UserLoginMapper mapper = new UserLoginMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result insert(UserLogin record) {
		return null;
	}

	@Override
	public Result insertSelective(UserLogin record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result updateByPrimaryKeySelective(UserLogin record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(UserLogin record) {
		return null;
	}

	@Override
	public Result getUserInfoByToken(String token) {
		UserLogin info = mapper.getUserInfoByToken(token);
		Result result;
		if (info != null) {
			result = Result.of(CodeEnum.SUCCESS);
			Map<String,Object> map = new HashMap<>();
			map.put("name",info.getRoleNumber());
			map.put("avatar","https://uploadfile.bizhizu.cn/up/f4/5b/c2/f45bc2e08c248093b75ae421f5df49ac.jpg");
			result.setData(map);
		} else {
			result = Result.of(CodeEnum.FAILURE);
		}
		return result;
	}
}
