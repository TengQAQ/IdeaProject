package com.ming.service;

import com.ming.dto.DelateCateDto;
import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamGoodsCategory;
import com.ming.vo.Result;

public interface HxzyExamGoodsCategoryService extends BaseService<Long, HxzyExamGoodsCategory>{
	Result selectAll(PageDto dto);

	Result DeleteCategory(DelateCateDto dto);
}
