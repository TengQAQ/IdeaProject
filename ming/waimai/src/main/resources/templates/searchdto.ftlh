<#assign aDateTime = .now>
<#assign aDate = aDateTime?date>
package com.hxzy.dto.back;

import com.hxzy.common.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @Author wy
* @Description ${tableNameDesc}查询
* @Date ${aDate?iso_utc}
* @Version 1.0
*/
@Getter
@Setter
@ToString
@ApiModel(value = "${tableNameDesc}查询")
public class ${entityName}SearchDTO extends PageDTO {

<#list searchParams as item>
    @ApiModelProperty(value = "${item.comments}")
    private ${item.javaDataType}  ${item.javaField};
 </#list>

}
