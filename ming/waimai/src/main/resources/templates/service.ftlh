package com.hxzy.service;

import com.hxzy.entity.${entityName};
import java.util.List;
import com.hxzy.dto.back.${entityName}SearchDTO;
<#if javaTypeList??>
    <#list javaTypeList as value >
import ${value};
    </#list>
</#if>


/**
*${tableNameDesc}业务逻辑
*/
public interface ${entityName}Service extends BaseService<${entityName}, ${primaryKeyType}> {

    /**
    * 分页查询
    * @param searchDTO
    * @return
    */
    List<${entityName}> search(${entityName}SearchDTO  searchDTO);

}