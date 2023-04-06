package com.ming.mapper;

import com.ming.entity.HxzyExamCategory;
import com.ming.entity.HxzyExamProduct;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【hxzy_exam_product】的数据库操作Mapper
* @createDate 2023-03-20 10:57:00
* @Entity com.ming.entity.HxzyExamProduct
*/
public interface HxzyExamProductMapper extends BaseMapper<String,HxzyExamProduct>{

    List<HxzyExamProduct> selectAll();
}
