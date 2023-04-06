package com.ming.service.impl;

import com.ming.entity.HrToken;
import com.ming.mapper.HrTokenMapper;
import com.ming.mapper.impl.HrTokenMapperImpl;
import com.ming.service.HrTokenService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class HrTokenServiceImpl implements HrTokenService {
	private HrTokenMapper mapper = new HrTokenMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(HrToken record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(HrToken record) {
		return Result.of(mapper.insertSelective(record),"动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		HrToken employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)){
			result = Result.of(CodeEnum.FAILURE);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(HrToken record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(HrToken record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result selectByToken(String token) {
		Result result;
		HrToken hrTokens = mapper.selectByToken(token);
		if (hrTokens.equals(null)){
			result = Result.of(CodeEnum.ILLEGAL_TOKEN);
		}else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(hrTokens);
		}
		return result;
	}

	@Override
	public Result logOut(String token) {
		return Result.of(mapper.logOut(token),"退出登录失败");
	}
}
