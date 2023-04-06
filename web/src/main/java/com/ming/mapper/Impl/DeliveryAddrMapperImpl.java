package com.ming.mapper.Impl;

import com.github.pagehelper.PageHelper;
import com.ming.Dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.mapper.DeliveryAddrMapper;
import com.ming.utils.SqlSessionHelper;

import java.util.List;

public class DeliveryAddrMapperImpl extends SqlSessionHelper implements DeliveryAddrMapper {
	@Override
	public Long deleteByPrimaryKey(Long id) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).deleteByPrimaryKey(id);
	}

	@Override
	public Long insert(DeliveryAddr record) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).insert(record);
	}

	@Override
	public Long insertSelective(DeliveryAddr record) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).insertSelective(record);
	}

	@Override
	public DeliveryAddr selectByPrimaryKey(Long id) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).selectByPrimaryKey(id);
	}

	@Override
	public Long updateByPrimaryKeySelective(DeliveryAddr record) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).updateByPrimaryKeySelective(record);
	}

	@Override
	public Long updateByPrimaryKey(DeliveryAddr record) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).updateByPrimaryKey(record);
	}

	@Override
	public List<DeliveryAddr> selectAll(PageDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getSize());
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).selectAll(dto);
	}

	@Override
	public int deletebatch(List<Long> lis) {
		return SqlSessionHelper.opensqlsession().getMapper(DeliveryAddrMapper.class).deletebatch(lis);
	}
}
