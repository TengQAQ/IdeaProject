package com.hxzy.mapper;

import com.hxzy.entity.HxzyExamGoodsCategory;

/**
* @author Administrator
* @description 针对表【hxzy_exam_goods_category】的数据库操作Mapper
* @createDate 2023-03-13 09:46:35
* @Entity com.hxzy.entity.HxzyExamGoodsCategory
*/
public interface HxzyExamGoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HxzyExamGoodsCategory record);

    int insertSelective(HxzyExamGoodsCategory record);

    HxzyExamGoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HxzyExamGoodsCategory record);

    int updateByPrimaryKey(HxzyExamGoodsCategory record);

}
