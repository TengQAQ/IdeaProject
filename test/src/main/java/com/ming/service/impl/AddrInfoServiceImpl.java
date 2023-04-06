package com.ming.service.impl;

import com.ming.dto.UserLoginDto;
import com.ming.entity.AddrInfo;
import com.ming.mapper.AddrInfoMapper;
import com.ming.mapper.impl.AddrInfoMapperImpl;
import com.ming.service.AddrInfoService;
import com.ming.util.JedisPoolUtils;
import com.ming.util.MD5Utils;
import com.ming.vo.AddrInfoVo;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AddrInfoServiceImpl implements AddrInfoService {
	private AddrInfoMapper mapper = new AddrInfoMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id), "删除失败");
	}

	@Override
	public Result insert(AddrInfo record) {
		return Result.of(mapper.insert(record), "新增失败");
	}

	@Override
	public Result insertSelective(AddrInfo record) {
		return Result.of(mapper.insertSelective(record), "动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		AddrInfo employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)) {
			result = Result.of(CodeEnum.FAILURE);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(AddrInfo record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record), "动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(AddrInfo record) {
		return Result.of(mapper.updateByPrimaryKey(record), "修改失败");
	}


	@Override
	public Result allAddrInfo() {
		Result result;
		List<AddrInfo> politicsstatuses = mapper.allAddrInfo();
		if (politicsstatuses.equals(null)) {
			result = Result.of(CodeEnum.FAILURE);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(politicsstatuses);
		}
		return result;
	}
}
