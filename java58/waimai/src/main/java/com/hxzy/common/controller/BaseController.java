package com.hxzy.common.controller;

import com.github.pagehelper.Page;
import com.hxzy.common.dto.PageDTO;
import com.hxzy.common.enums.AckCode;
import com.hxzy.common.vo.PageVO;
import com.hxzy.common.vo.R;

import java.util.List;

/**
 * @Author wy
 * @Description 基础的控制器
 * @Date 2023/4/8 9:15
 * @Version 1.0
 */
public class BaseController {

    /**
     * 分页page转换成自定义PageVO
     * @param list
     * @param <T>
     * @return
     */
    public <T> R<PageVO<T>>  pageToPageVO(List<T> list){
        PageVO<T>  pageVO=new PageVO();

        if(list instanceof Page){
            Page pg= (Page) list;
            pageVO.setTotal(pg.getTotal());
            pageVO.setRows(pg.getResult());

        }else{
            pageVO.setRows(list);
            pageVO.setTotal(0L);
        }
        return R.okHasData(pageVO);
    }

    public R toR(int count) {
        return count>0? R.ok(): R.build(AckCode.FAIL);
    }

    public R toR(boolean count){
        return count ? R.ok(): R.build(AckCode.FAIL);
    }
}
