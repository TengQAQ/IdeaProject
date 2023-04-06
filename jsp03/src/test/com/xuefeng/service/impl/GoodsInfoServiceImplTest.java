package com.xuefeng.service.impl;

import com.xuefeng.dto.PageDto;
import com.xuefeng.service.GoodsInfoService;
import com.xuefeng.vo.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsInfoServiceImplTest {
    private GoodsInfoService service = new GoodsInfoServiceImpl();
    @Test
    public void selectAll() {
        PageDto pageDto = new PageDto();
        Result result = service.selectAll(pageDto);
        System.out.println(result);
    }

    @Test
    public void deleteByPrimaryKey(){
        Result result = service.deleteByPrimaryKey(92L);
        System.out.println(result);
    }
}