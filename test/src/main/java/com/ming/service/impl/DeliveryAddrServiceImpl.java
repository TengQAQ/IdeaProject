package com.ming.service.impl;

import com.github.pagehelper.PageInfo;
import com.ming.dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.entity.DeliveryAddr;
import com.ming.mapper.DeliveryAddrMapper;
import com.ming.mapper.impl.DeliveryAddrMapperImpl;
import com.ming.service.DeliveryAddrService;
import com.ming.vo.CodeEnum;
import com.ming.vo.PageVo;
import com.ming.vo.Result;

import java.util.List;

public class DeliveryAddrServiceImpl implements DeliveryAddrService {
	private DeliveryAddrMapper mapper = new DeliveryAddrMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		return Result.of(mapper.deleteByPrimaryKey(id), "删除失败");
	}

	@Override
	public Result insert(DeliveryAddr record) {
		return Result.of(mapper.insert(record), "新增失败");
	}

	@Override
	public Result insertSelective(DeliveryAddr record) {
		return Result.of(mapper.insertSelective(record), "动态新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		Result result;
		DeliveryAddr employee = mapper.selectByPrimaryKey(id);
		if (employee.equals(null)) {
			result = Result.of(CodeEnum.FAILURE);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(employee);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(DeliveryAddr record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record), "动态修改失败");
	}

	@Override
	public Result updateByPrimaryKey(DeliveryAddr record) {
		return Result.of(mapper.updateByPrimaryKey(record), "修改失败");
	}

	@Override
	public Result selectAll(PageDto pageDto) {
		Result result;
		List<DeliveryAddr> deliveryAddrs = mapper.selectAll(pageDto);
		PageInfo<DeliveryAddr> of = PageInfo.of(deliveryAddrs);
		PageVo<DeliveryAddr> deliveryAddrPageVo = PageVo.of(of);
		if (deliveryAddrs.equals(null)) {
			result = Result.of(CodeEnum.FAILURE);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(deliveryAddrPageVo);
		}
		return result;
	}
}
