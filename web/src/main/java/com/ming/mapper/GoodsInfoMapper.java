package com.ming.mapper;

import com.ming.Dto.PageDto;
import com.ming.entity.GoodsInfo;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【goods_info】的数据库操作Mapper
* @createDate 2023-02-23 15:11:38
* @Entity com.ming.entity.GoodsInfo
*/
public interface GoodsInfoMapper extends BaseMapper<Integer,GoodsInfo>{
    List<GoodsInfo> SelectAllGoodsInfo(PageDto dto);
}
