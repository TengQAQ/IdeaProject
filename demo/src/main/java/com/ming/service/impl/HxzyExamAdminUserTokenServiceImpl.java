package com.ming.service.impl;

import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.HxzyExamAdminUserTokenMapper;
import com.ming.mapper.impl.HxzyExamAdminUserTokenMapperImpl;
import com.ming.service.HxzyExamAdminUserTokenService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.HashMap;
import java.util.Map;

public class HxzyExamAdminUserTokenServiceImpl implements HxzyExamAdminUserTokenService {
	private HxzyExamAdminUserTokenMapper mapper = new HxzyExamAdminUserTokenMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result insert(HxzyExamAdminUserToken record) {
		return null;
	}

	@Override
	public Result insertSelective(HxzyExamAdminUserToken record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamAdminUserToken record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamAdminUserToken record) {
		return null;
	}

	@Override
	public Result selectByToken(String token) {
		Result result;
		HxzyExamAdminUserToken hxzyExamAdminUserToken = mapper.selctByToken(token);
		if (hxzyExamAdminUserToken != null){
			result = Result.of(CodeEnum.SUCCESS);
			Map<String,Object> map = new HashMap<>();
			map.put("name",hxzyExamAdminUserToken.getUserName());
			System.out.println("=================hxzyExamAdminUserToken"+hxzyExamAdminUserToken.getUserName());
			map.put("avatar","https://tupian.qqw21.com/article/UploadPic/2021-1/20211722215388977.jpg");
			result.setData(map);
		}else {
			result = Result.of(CodeEnum.FAILURE);
		}
		return result;
	}

	@Override
	public Result logOut(String token) {
		int logOut = mapper.logOut(token);
		if (logOut == 0){
			return Result.of(CodeEnum.FAILURE);
		}else {
			return Result.of(CodeEnum.SUCCESS);
		}
	}
}
