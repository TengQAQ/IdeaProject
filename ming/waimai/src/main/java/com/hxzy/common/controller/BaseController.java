package com.hxzy.common.controller;


import com.github.pagehelper.Page;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.vo.PageVO;
import com.hxzy.vo.Result;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/12-23:56
 * @description TODO
 */
public class BaseController {

    /**
     * 分页page转换成自定义PageVO
     * @param list
     * @param <T>
     * @return
     */
    public <T> Result<PageVO<T>>  pageToPageVO(List<T> list){
        PageVO<T>  pageVO=new PageVO();

        if(list instanceof Page){
            Page pg= (Page) list;
            pageVO.setTotal(pg.getTotal());
            pageVO.setRows(pg.getResult());

        }else{
            pageVO.setRows(list);
            pageVO.setTotal(0L);
        }
        return Result.okHasData(pageVO);
    }

    public Result toR(int count) {
        return count>0? Result.ok(): Result.build(AckCode.FAIL);
    }

    public Result toR(boolean count){
        return count ? Result.ok(): Result.build(AckCode.FAIL);
    }
}
