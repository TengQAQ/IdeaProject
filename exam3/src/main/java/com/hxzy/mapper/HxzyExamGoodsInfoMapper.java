package com.hxzy.mapper;

import com.hxzy.entity.HxzyExamGoodsInfo;

/**
* @author Administrator
* @description 针对表【hxzy_exam_goods_info】的数据库操作Mapper
* @createDate 2023-03-13 09:46:35
* @Entity com.hxzy.entity.HxzyExamGoodsInfo
*/
public interface HxzyExamGoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HxzyExamGoodsInfo record);

    int insertSelective(HxzyExamGoodsInfo record);

    HxzyExamGoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxzyExamGoodsInfo record);

    int updateByPrimaryKey(HxzyExamGoodsInfo record);

}
