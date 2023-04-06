package com.ming.mapper;

import com.ming.dto.PageDto;
import com.ming.entity.DeliveryAddr;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【delivery_addr】的数据库操作Mapper
* @createDate 2023-03-30 15:13:58
* @Entity com.ming.entity.DeliveryAddr
*/
public interface DeliveryAddrMapper extends BaseMapper<Integer,DeliveryAddr>{
	List<DeliveryAddr> selectAll(PageDto pageDto);
}
