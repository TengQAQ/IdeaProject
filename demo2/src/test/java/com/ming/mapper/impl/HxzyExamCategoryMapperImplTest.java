package com.ming.mapper.impl;

import com.ming.entity.HxzyExamCategory;
import com.ming.mapper.HxzyExamCategoryMapper;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HxzyExamCategoryMapperImplTest {
private  final HxzyExamCategoryMapper mapper = new HxzyExamCategoryMapperImpl();
	@Test
	public void selectAll() {
		List<HxzyExamCategory> hxzyExamCategories = mapper.selectAll();
		hxzyExamCategories.stream().forEach(item-> System.out.println(item.toString()));
	}
}