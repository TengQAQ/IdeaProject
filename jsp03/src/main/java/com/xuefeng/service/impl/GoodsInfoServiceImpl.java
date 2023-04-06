package com.xuefeng.service.impl;

import com.github.pagehelper.PageInfo;
import com.xuefeng.dto.PageDto;
import com.xuefeng.entity.GoodsInfo;
import com.xuefeng.mapper.GoodsInfoMapper;
import com.xuefeng.mapper.impl.GoodsInfoMapperImpl;
import com.xuefeng.service.GoodsInfoService;
import com.xuefeng.vo.CodeEnum;
import com.xuefeng.vo.PageVo;
import com.xuefeng.vo.Result;

import java.util.List;

public class GoodsInfoServiceImpl implements GoodsInfoService {
    // 调用数据访问层
    private GoodsInfoMapper mapper = new GoodsInfoMapperImpl();

    @Override
    public Result deleteByPrimaryKey(Long id) {
        int update = mapper.deleteByPrimaryKey(id);
        return Result.of(update, "删除失败");
    }

    @Override
    public Result insert(GoodsInfo record) {
        int update = mapper.insert(record);
        return Result.of(update, "新增失败");
    }

    @Override
    public Result insertSelective(GoodsInfo record) {
        int update = mapper.insertSelective(record);
        return Result.of(update, "新增失败");
    }

    @Override
    public Result selectByPrimaryKey(Long id) {
        GoodsInfo goodsInfo = mapper.selectByPrimaryKey(id);
        Result result = new Result(20000, null);
        // 将查询的数据设置到结果中
        result.setData(goodsInfo);
        return result;
    }

    @Override
    public Result updateByPrimaryKeySelective(GoodsInfo record) {
        int update = mapper.updateByPrimaryKeySelective(record);
        return Result.of(update, "修改失败");
    }

    @Override
    public Result updateByPrimaryKey(GoodsInfo record) {
        int update = mapper.updateByPrimaryKey(record);
        return Result.of(update, "修改失败");
    }

    @Override
    public Result selectAll(PageDto dto) {
        List<GoodsInfo> list = mapper.selectAll(dto);
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
