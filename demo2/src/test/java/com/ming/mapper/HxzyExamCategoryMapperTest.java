package com.ming.mapper;

import com.ming.entity.HxzyExamCategory;
import com.ming.mapper.impl.HxzyExamCategoryMapperImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HxzyExamCategoryMapperTest {
	private HxzyExamCategoryMapper mapper = new HxzyExamCategoryMapperImpl();

	@Test
	public void gradeJudgment() {
		HxzyExamCategory hxzyExamCategories = mapper.gradeJudgment(new Long(7));

		Map<Integer,String> map = new HashMap<>();

	}
}