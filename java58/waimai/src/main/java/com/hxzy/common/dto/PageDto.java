package com.hxzy.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-17:56
 * @description TODO
 */

@Getter
@Setter
@ToString
public class PageDto {
    private int PageNum = 5;
    private int PageSize = 0;
}
