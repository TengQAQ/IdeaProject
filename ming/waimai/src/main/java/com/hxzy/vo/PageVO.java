package com.hxzy.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-16:09
 * @description TODO
 */
@Getter
@Setter
@ToString
public class PageVO<T> {
    private Long total;
    private List<T> rows;
}
