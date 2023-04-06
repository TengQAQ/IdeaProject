package com.ming.service;

import com.ming.dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.vo.Result;

import java.util.List;

public interface DeliveryAddrService extends BaseService<Integer, DeliveryAddr>{
	Result selectAll(PageDto pageDto);
}
