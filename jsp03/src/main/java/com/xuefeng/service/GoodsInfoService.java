package com.xuefeng.service;

import com.xuefeng.dto.PageDto;
import com.xuefeng.entity.GoodsInfo;
import com.xuefeng.vo.Result;

public interface GoodsInfoService extends BaseService<Long, GoodsInfo>{
    /**
     * 分页全查
     *
     * @return
     */
    Result selectAll(PageDto dto);
}
