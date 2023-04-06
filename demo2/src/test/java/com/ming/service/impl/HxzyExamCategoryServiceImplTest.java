package com.ming.service.impl;

import com.ming.service.HxzyExamCategoryService;
import com.ming.vo.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class HxzyExamCategoryServiceImplTest {
	HxzyExamCategoryService service = new HxzyExamCategoryServiceImpl();

	@Test
	public void getCategory() {
		Result result = service.getCategory();
		System.out.println(result);
	}
}