package com.ming.service.impl;

import com.ming.entity.HxzyExamProduct;
import com.ming.mapper.HxzyExamProductMapper;
import com.ming.mapper.impl.HxzyExamProductMapperImpl;
import com.ming.service.HxzyExamProductService;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;

import java.util.List;

public class HxzyExamProductServiceImpl implements HxzyExamProductService {
	private HxzyExamProductMapper mapper = new HxzyExamProductMapperImpl();
	@Override
	public Result deleteByPrimaryKey(String id) {
		int deleteByPrimaryKey = mapper.deleteByPrimaryKey(id);
		return Result.of(deleteByPrimaryKey,"删除失败");
	}

	@Override
	public Result insert(HxzyExamProduct record) {
		return Result.of(mapper.insert(record),"新增失败");
	}

	@Override
	public Result insertSelective(HxzyExamProduct record) {
		return Result.of(mapper.insertSelective(record),"新增失败");
	}

	@Override
	public Result selectByPrimaryKey(String id) {
		Result result;
		HxzyExamProduct hxzyExamProduct = mapper.selectByPrimaryKey(id);
		if (hxzyExamProduct == null){
			return Result.of(CodeEnum.FAILURE);
		}
		result = Result.of(CodeEnum.SUCCESS);
		result.setData(hxzyExamProduct);
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(HxzyExamProduct record) {
		return Result.of(mapper.updateByPrimaryKeySelective(record),"修改失败");
	}

	@Override
	public Result updateByPrimaryKey(HxzyExamProduct record) {
		return Result.of(mapper.updateByPrimaryKey(record),"修改失败");
	}

	@Override
	public Result selectAll() {
		Result result;
		List<HxzyExamProduct> hxzyExamProducts = mapper.selectAll();
		if (hxzyExamProducts == null){
			return Result.of(CodeEnum.FAILURE);
		}
		result = Result.of(CodeEnum.SUCCESS);
		result.setData(hxzyExamProducts);
		return result;
	}
}
