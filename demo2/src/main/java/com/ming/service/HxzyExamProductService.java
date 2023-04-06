package com.ming.service;

import com.ming.entity.HxzyExamProduct;
import com.ming.vo.Result;

import java.util.List;

public interface HxzyExamProductService extends BaseService<String,HxzyExamProduct>{
	Result selectAll();
}
