package com.ming.service;

import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamCategory;
import com.ming.vo.Result;

import java.util.List;

public interface HxzyExamCategoryService extends BaseService<Long, HxzyExamCategory>{
	Result selectAll();

	Result gradeJudgment(Long paramId);

	Result BashDelCate(List list);

	Result getCategory();
}
