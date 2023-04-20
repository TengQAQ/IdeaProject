package com.hxzy.dto;

import com.hxzy.vo.back.TableNameColumnsVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-14:35
 * @description TODO
 */
@Getter
@Setter
@ToString
public class TableNameSaveDTO {

    /**
     * 表名
     */
    @NotBlank(message = "表名不能为空")
    private String tableName;

    /**
     * 列信息
     */
    @NotNull(message = "列信息不允许为空")
    private List<TableNameColumnsVO> columns;
}
