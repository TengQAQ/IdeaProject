package com.ming.mapper;

import com.ming.entity.HxzyExamCategory;
import com.ming.vo.CategoryVo;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【hxzy_exam_category】的数据库操作Mapper
* @createDate 2023-03-16 14:06:52
* @Entity com.ming.entity.HxzyExamCategory
*/
public interface HxzyExamCategoryMapper extends BaseMapper<Long,HxzyExamCategory>{
	List<HxzyExamCategory> selectAll();

	List<CategoryVo> getCategory();

	HxzyExamCategory gradeJudgment(Long paramId);

	int BashDelCate(List list);
}
