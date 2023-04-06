package com.ming.service.impl;

import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamCategory;
import com.ming.mapper.HxzyExamCategoryMapper;
import com.ming.mapper.impl.HxzyExamCategoryMapperImpl;
import com.ming.service.HxzyExamCategoryService;
import com.ming.vo.CategoryVo;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HxzyExamCategoryServiceImpl implements HxzyExamCategoryService {
	private HxzyExamCategoryMapper mapper = new HxzyExamCategoryMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Long id) {
		int i = mapper.deleteByPrimaryKey(id);
		return Result.of(i, "删除失败");
	}

	@Override
	public Result insert(HxzyExamCategory record) {
		int i = mapper.insert(record);
		return Result.of(i, "新增失败");
	}

	@Override
	public Result insertSelective(HxzyExamCategory record) {
		int i = mapper.insertSelective(record);
		return Result.of(i, "新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Long id) {
		Result result;
		HxzyExamCategory i = mapper.selectByPrimaryKey(id);
		if (i == null) {
			result = Result.of(CodeEnum.FAILURE);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(i);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamCategory record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record), "修改失败");
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamCategory record) {
		return Result.of(mapper.updateByPrimaryKey(record), "修改失败");
	}

	@Override
	public Result selectAll() {
		Result result;
		List<HxzyExamCategory> i = mapper.selectAll();
		if (i.equals(null)) {
			result = Result.of(CodeEnum.FAILURE);
		} else {
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(i);
		}
		return result;
	}

	@Override
	public Result gradeJudgment(Long paramId) {
		Result result = Result.of(CodeEnum.SUCCESS);
		HxzyExamCategory hxzyExamCategory = mapper.gradeJudgment(paramId);
		System.out.println(hxzyExamCategory.toString());
		Map<String,Boolean> map = new HashMap<>();
		if (hxzyExamCategory.getParentId() == "0"){
			map.put("isAllowAdd",true);
		}else {
			map.put("isAllowAdd",false);
		}
		result.setData(map);
		return result;
	}

	@Override
	public Result BashDelCate(List list) {
		return Result.of(mapper.BashDelCate(list), "删除失败");
	}

	@Override
	public Result getCategory() {
		Result result = Result.of(CodeEnum.SUCCESS);
		List<CategoryVo> category = mapper.getCategory();
		List<CategoryVo> subCategory = getSubCategory(category, 0);

		result.setData(subCategory);
		return result;
	}

	public List<CategoryVo> getSubCategory(List<CategoryVo> allCategories, Integer parentId) {
		// 声明一个集合用于保存二级菜单
		List<CategoryVo> voList = new ArrayList<>(); // {5,10}
		// 通过递归查找topVo一级菜单的2级菜单
		for (CategoryVo categoryVo : allCategories) {
			if (categoryVo.getParentId() == parentId) {
				voList.add(categoryVo);
			}
		}

		// 遍历voList，为每个categoryVo查找子节点
		for (CategoryVo categoryVo : voList) { // id:5,children:{11,12,13}
			List<CategoryVo> subCategory = getSubCategory(allCategories, categoryVo.getId());
			if (!subCategory.isEmpty()) {
				categoryVo.setChildren(subCategory);
			}
		}
		return voList;
	}
}