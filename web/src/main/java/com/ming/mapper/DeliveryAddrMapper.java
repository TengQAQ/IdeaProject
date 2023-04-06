package com.ming.mapper;

import com.ming.Dto.PageDto;
import com.ming.entity.DeliveryAddr;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【delivery_addr】的数据库操作Mapper
* @createDate 2023-02-13 16:56:30
* @Entity com.ming.entity.DeliveryAddr
*/
public interface DeliveryAddrMapper extends BaseMapper<Long,DeliveryAddr>{

    @Override
    Long deleteByPrimaryKey(Long id);

    @Override
    Long insert(DeliveryAddr record);

    @Override
    Long insertSelective(DeliveryAddr record);

    @Override
    DeliveryAddr selectByPrimaryKey(Long id);

    @Override
    Long updateByPrimaryKeySelective(DeliveryAddr record);

    @Override
    Long updateByPrimaryKey(DeliveryAddr record);

    List<DeliveryAddr> selectAll(PageDto dto);

    int deletebatch(List<Long> lis);
}
