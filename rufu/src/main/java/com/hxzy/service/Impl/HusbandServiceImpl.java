package com.hxzy.service.Impl;

import com.hxzy.entity.Husband;
import com.hxzy.mapper.HusbandMapper;
import com.hxzy.mapper.Impl.HusbandMapperImpl;
import com.hxzy.service.HusbandService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;

public class HusbandServiceImpl implements HusbandService {
	private HusbandMapper mapper = new HusbandMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public Result insert(Husband record) {
		return null;
	}

	@Override
	public Result insertSelective(Husband record) {
		return null;
	}

	@Override
	public Result selectByPrimaryKey(Long id) {
		Husband husband = mapper.selectByPrimaryKey(id);
		Result result = null;
		if (husband != null){
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(husband);
		}else {
			result = result.of(CodeEnum.FAILURE);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Husband record) {
		return null;
	}

	@Override
	public Result updateByPrimaryKey(Husband record) {
		return null;
	}
}
