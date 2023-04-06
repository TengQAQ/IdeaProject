package com.ming.mapper;

import com.ming.entity.GoodsInfo;

/**
* @author QinTeng
* @description 针对表【goods_info】的数据库操作Mapper
* @createDate 2023-02-10 12:41:10
* @Entity com.ming.entity.GoodsInfo
*/
public interface GoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

}
