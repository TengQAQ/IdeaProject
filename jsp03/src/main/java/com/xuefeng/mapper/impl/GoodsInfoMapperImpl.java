package com.xuefeng.mapper.impl;

import com.github.pagehelper.PageHelper;
import com.xuefeng.dto.PageDto;
import com.xuefeng.entity.GoodsInfo;
import com.xuefeng.mapper.GoodsInfoMapper;
import com.xuefeng.utils.BaseHelper;

import java.util.List;

public class GoodsInfoMapperImpl extends BaseHelper implements GoodsInfoMapper {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return super.dml(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.deleteByPrimaryKey(id);
        });
    }

    @Override
    public int insert(GoodsInfo record) {
        return super.dml(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.insert(record);
        });
    }

    @Override
    public int insertSelective(GoodsInfo record) {
        return super.dml(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.insertSelective(record);
        });
    }

    @Override
    public GoodsInfo selectByPrimaryKey(Long id) {
        return super.query(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.selectByPrimaryKey(id);
        });
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo record) {
        return super.dml(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.updateByPrimaryKeySelective(record);
        });
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {
        return super.dml(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.updateByPrimaryKey(record);
        });
    }


    public List<GoodsInfo> selectAll(PageDto dto) {
        // 在进行分页查询之前，一定要先使用分类插件进行拦截
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        return super.query(sqlSession -> {
            GoodsInfoMapper mapper = sqlSession.getMapper(GoodsInfoMapper.class);
            return mapper.selectAll(dto);
        });
    }
}
