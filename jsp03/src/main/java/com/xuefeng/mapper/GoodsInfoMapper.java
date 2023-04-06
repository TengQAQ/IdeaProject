package com.xuefeng.mapper;

import com.xuefeng.dto.PageDto;
import com.xuefeng.entity.GoodsInfo;

import java.util.List;

/**
* @author h'p
* @description 针对表【goods_info】的数据库操作Mapper
* @createDate 2023-02-23 19:05:17
* @Entity com.xuefeng.entity.GoodsInfo
*/
public interface GoodsInfoMapper extends BaseMapper<Long, GoodsInfo>{


    List<GoodsInfo> selectAll(PageDto dto);
}
