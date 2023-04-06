package com.hxzy.service.Impl;

import com.github.pagehelper.PageInfo;
import com.hxzy.Dto.PageDto;
import com.hxzy.Dto.SearchDto;
import com.hxzy.entity.Elementary;
import com.hxzy.mapper.ElementaryMapper;
import com.hxzy.mapper.Impl.ElementaryMapperImpl;
import com.hxzy.service.ElementaryService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.PageVo;
import com.hxzy.vo.Result;

import java.util.List;

public class ElementaryServiceImpl implements ElementaryService {
	private ElementaryMapper mapper =new ElementaryMapperImpl();
	@Override
	public Result deleteByPrimaryKey(String id) {
		int i = mapper.deleteByPrimaryKey(id);
		Result result = Result.of(i,"删除失败");
		return result;
	}

	@Override
	public Result insert(Elementary record) {
		int i = mapper.insert(record);
		Result result = Result.of(i,"新增失败");
		return result;
	}

	@Override
	public Result insertSelective(Elementary record) {
		int i = mapper.insertSelective(record);
		Result result = Result.of(i,"动态新增失败");
		return result;
	}

	@Override
	public Result selectByPrimaryKey(String id) {
		Elementary i = mapper.selectByPrimaryKey(id);
		Result result = new Result();
		if (i != null){
			result.setData(result);
		}else {
			result = Result.of(0,"查询失败");
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(Elementary record) {
		int i = mapper.updateByPrimaryKeySelective(record);
		Result result = Result.of(i,"动态修改失败");
		return result;
	}

	@Override
	public Result updateByPrimaryKey(Elementary record) {
		int i = mapper.updateByPrimaryKey(record);
		Result result = Result.of(i,"修改失败");
		return result;
	}

	@Override
	public Result SelectAllElementary(SearchDto dto) {
		List<Elementary> list = mapper.SelectAllElementary(dto);
		PageInfo<Elementary> pageInfo = PageInfo.of(list);
		PageVo<Elementary> pageVo = PageVo.of(pageInfo);
		Result result = Result.of(CodeEnum.SUCCESS);
		result.setData(pageVo);
		return result;
	}
}
