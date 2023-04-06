package com.ming.service.Impl;

import com.github.pagehelper.PageInfo;
import com.ming.Dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.entity.GoodsInfo;
import com.ming.mapper.GoodsInfoMapper;
import com.ming.mapper.Impl.GoodsInfoMapperImpl;
import com.ming.service.GoodsInfoService;
import com.ming.vo.CodeEnum;
import com.ming.vo.PageVo;
import com.ming.vo.Result;

import java.util.List;

public class GoodsInfoServiceImpl implements GoodsInfoService {
	private GoodsInfoMapper mapper = new GoodsInfoMapperImpl();

	@Override
	public Result deleteByPrimaryKey(Integer id) {
		Long update = Long.valueOf(mapper.deleteByPrimaryKey(id));
		return Result.of(update, "删除失败");
	}


	@Override
	public Result insert(GoodsInfo record) {
		Long update = Long.valueOf(mapper.insert(record));
		return Result.of(update, "新增失败");
	}


	@Override
	public Result insertSelective(GoodsInfo record) {
		Long update = Long.valueOf(mapper.insertSelective(record));
		return Result.of(update, "新增失败");
	}

	@Override
	public Result selectByPrimaryKey(Integer id) {
		GoodsInfo goodsInfo = mapper.selectByPrimaryKey(id);
		Result result = new Result(20000, null);
		// 将查询的数据设置到结果中
		result.setData(goodsInfo);
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(GoodsInfo record) {
		Long update = Long.valueOf(mapper.updateByPrimaryKeySelective(record));
		return Result.of(update, "修改失败");
	}


	@Override
	public Result updateByPrimaryKey(GoodsInfo record) {
		Long update = Long.valueOf(mapper.updateByPrimaryKey(record));
		return Result.of(update, "修改失败");
	}

	@Override
	public Result selectAll(PageDto dto) {
		List<GoodsInfo> list = mapper.SelectAllGoodsInfo(dto);
		// PageInfo中包含了分页信息，分页数据等等
		PageInfo<GoodsInfo> pageInfo = PageInfo.of(list);
		// 在前端分页时，只会关心： pageNum,pageSize,list,total
		PageVo<GoodsInfo> pageVo = PageVo.of(pageInfo);
		// 查询不会失败，当查询不到数据时，返回一个空的集合即可
		Result result = Result.of(CodeEnum.SUCCESS);
		result.setData(pageVo);
		return result;
	}
}
