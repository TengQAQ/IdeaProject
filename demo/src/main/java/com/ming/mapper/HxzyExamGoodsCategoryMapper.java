package com.ming.mapper;

import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamGoodsCategory;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【hxzy_exam_goods_category】的数据库操作Mapper
* @createDate 2023-03-13 12:23:49
* @Entity com.ming.entity.HxzyExamGoodsCategory
*/
public interface HxzyExamGoodsCategoryMapper extends BaseMapper<Long,HxzyExamGoodsCategory>{
	List<HxzyExamGoodsCategory> selectAll(PageDto dto);

	int DeleteOneRank(Long id);

	int DeleteTwoRank(Long id);

	int DeleteThreeRank(Long id);

}
