package com.ming.service.Impl;

import com.ming.Dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.mapper.DeliveryAddrMapper;
import com.ming.mapper.Impl.DeliveryAddrMapperImpl;
import com.ming.service.DeliveryAddrService;

import java.util.List;

public class DeliveryAddrServiceImpl implements DeliveryAddrService {
	DeliveryAddrMapper mapper = new DeliveryAddrMapperImpl();
	@Override
	public Long deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Long insert(DeliveryAddr record) {
		return mapper.insert(record);
	}

	@Override
	public Long insertSelective(DeliveryAddr record) {
		return mapper.insertSelective(record);
	}

	@Override
	public DeliveryAddr selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Long updateByPrimaryKeySelective(DeliveryAddr record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateByPrimaryKey(DeliveryAddr record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DeliveryAddr> selectAll(PageDto dto) {
		return mapper.selectAll(dto);
	}

	@Override
	public int deletebatch(List<Long> lis) {
		return mapper.deletebatch(lis);
	}
}
