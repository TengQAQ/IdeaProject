package com.xuefeng.vo;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 统一的分页查询返回结果
 * @param <T>
 */
public class PageVo<T> {
    private Integer pageNum;
    private Integer pageSize;
    // 总条数
    private Long total;
    // 分页查询的数据
    private List<T> list;

    /**
     * 通过读取pageInfo去构建一个pageVo
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> PageVo<T> of(PageInfo<T> pageInfo){
        PageVo<T> pageVo = new PageVo<>();
        // 设置条数
        pageVo.setTotal(pageInfo.getTotal());
        pageVo.setPageNum(pageInfo.getPageNum());
        pageVo.setPageSize(pageInfo.getPageSize());
        pageVo.setList(pageInfo.getList());
        return pageVo;
    }

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
