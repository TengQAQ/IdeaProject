package com.ming.service.impl;

import com.ming.entity.HxzyExamAdminUser;
import com.ming.entity.HxzyExamAdminUserToken;
import com.ming.mapper.HxzyExamAdminUserTokenMapper;
import com.ming.mapper.impl.HxzyExamAdminUserTokenMapperImpl;
import com.ming.service.HxzyExamAdminUserTokenService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

public class HxzyExamAdminUserTokenServiceImpl implements HxzyExamAdminUserTokenService {
	private HxzyExamAdminUserTokenMapper mapper = new HxzyExamAdminUserTokenMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Long id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");

	}

	@Override
	public Result insert(HxzyExamAdminUserToken record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(HxzyExamAdminUserToken record) {
		return Result.of(mapper.insertSelective(record),"新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Long id) {
		Result result;
		HxzyExamAdminUserToken hxzyExamAdminUserToken = mapper.selectByPrimaryKey(id);
		if (!(hxzyExamAdminUserToken == null)){
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(hxzyExamAdminUserToken);
			return result;
		}else {
			result = Result.of(CodeEnum.FAILURE);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamAdminUserToken record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"修改失败");
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamAdminUserToken record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result selectByToken(String token) {
		Result result;
		HxzyExamAdminUserToken hxzyExamAdminUserToken = mapper.selectByToken(token);
		if (!(hxzyExamAdminUserToken == null)){
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(hxzyExamAdminUserToken);
			return result;
		}else {
			result = Result.of(CodeEnum.FAILURE);
		}
		return result;
	}

	@Override
	public Result logOut(String token) {
		return Result.of(mapper.logOut(token),"退出失败");
	}
}
