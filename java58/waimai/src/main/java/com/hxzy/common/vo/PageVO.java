package com.hxzy.common.vo;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-16:09
 * @description TODO
 */
public class PageVO<T> {
    private Long total;
    private List<T> rows;

    @Override
    public String toString() {
        return "PageVO{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
