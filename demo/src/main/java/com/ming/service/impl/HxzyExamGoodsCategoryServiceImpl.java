package com.ming.service.impl;

import com.ming.dto.DelateCateDto;
import com.ming.dto.PageDto;
import com.ming.entity.HxzyExamGoodsCategory;
import com.ming.mapper.HxzyExamGoodsCategoryMapper;
import com.ming.mapper.impl.HxzyExamGoodsCategoryMapperImpl;
import com.ming.service.HxzyExamGoodsCategoryService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class HxzyExamGoodsCategoryServiceImpl implements HxzyExamGoodsCategoryService {
	private HxzyExamGoodsCategoryMapper mapper = new HxzyExamGoodsCategoryMapperImpl();
	@Override
	public Result deleteByPrimaryKey(Long id) {
		return Result.of(mapper.deleteByPrimaryKey(id),"删除失败");
	}

	@Override
	public Result insert(HxzyExamGoodsCategory record) {
		int i = mapper.insert(record);
		return Result.of(i,"新增失败");
	}

	@Override
	public Result insertSelective(HxzyExamGoodsCategory record) {
		int i = mapper.insertSelective(record);
		return Result.of(i,"新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Long id) {
		HxzyExamGoodsCategory i = mapper.selectByPrimaryKey(id);
		if (i.equals(null)){
			return Result.of(CodeEnum.FAILURE);
		}
		Result result = Result.of(CodeEnum.SUCCESS);
		result.setData(i);
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamGoodsCategory record) {
		int update = mapper.updateByPrimaryKeySelective(record);
		return Result.of(update,"修改失败");
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamGoodsCategory record) {
		int update = mapper.updateByPrimaryKey(record);
		return Result.of(update,"修改失败");
	}

	@Override
	public Result selectAll(PageDto dto) {
		Result result;
		List<HxzyExamGoodsCategory> hxzyExamGoodsCategories = mapper.selectAll(dto);
		if(hxzyExamGoodsCategories != null){
			result = Result.of(CodeEnum.SUCCESS);
			result.setData(hxzyExamGoodsCategories);
		}else {
			result = Result.of(CodeEnum.FAILURE);
		}
		return result;
	}

	@Override
	public Result DeleteCategory(DelateCateDto dto) {
		int i;
		switch (dto.getCategoryLevel()){
			case 1:
				mapper.DeleteOneRank(dto.getCategoryId());
				mapper.DeleteTwoRank(dto.getCategoryId());
				i = mapper.DeleteThreeRank(dto.getCategoryId());
				return Result.of(i, "删除失败");
			case 2:
				mapper.DeleteTwoRank(dto.getCategoryId());
				i = mapper.DeleteThreeRank(dto.getCategoryId());
				return Result.of(i, "删除失败");
			case 3:
				i = mapper.DeleteThreeRank(dto.getCategoryId());
				return Result.of(i, "删除失败");
		}
		return Result.of(CodeEnum.FAILURE);
	}
}
