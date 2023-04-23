<#assign aDateTime = .now>
<#assign aDate = aDateTime?date>
package com.hxzy.mapper;
import com.hxzy.dto.back.${entityName}SearchDTO;
import com.hxzy.entity.${entityName};
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
<#if javaTypeList??>
    <#list javaTypeList as value >
import ${value};
    </#list>
</#if>

/**
* @Author wy
* @Description ${tableNameDesc} 数据访问
* @Date ${aDate?iso_utc}
* @Version 1.0
*/
@Mapper
public interface ${entityName}Mapper extends BaseMapper<${entityName},${primaryKeyType}> {

    /**
    * 分页查询
    * @param dto
    * @return
    */
    List<${entityName}> search(@Param(value = "dto") ${entityName}SearchDTO dto);
}