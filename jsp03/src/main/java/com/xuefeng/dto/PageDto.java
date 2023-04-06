package com.xuefeng.dto;

public class PageDto {
    // 默认查询第一页
    private Integer pageNum = 1;
    // 默认每页查询5条数据
    private Integer pageSize = 5;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
