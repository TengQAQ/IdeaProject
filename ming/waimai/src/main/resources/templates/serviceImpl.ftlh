<#assign aDateTime = .now>
<#assign aDate = aDateTime?date>
package com.hxzy.service.impl;


import com.hxzy.entity.${entityName};
import com.hxzy.mapper.${entityName}Mapper;
import com.hxzy.service.${entityName}Service;
import com.hxzy.dto.back.${entityName}SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
<#if javaTypeList??>
    <#list javaTypeList as value >
import ${value};
    </#list>
</#if>


/**
* @Author wy
* @Description ${tableNameDesc}业务逻辑
* @Date ${aDate?iso_utc}
* @Version 1.0
*/
@Service
public class ${entityName}ServiceImpl extends ServiceImpl<${entityName},${primaryKeyType}>  implements ${entityName}Service {

    private ${entityName}Mapper  ${entityName?uncap_first}Mapper;

    @Autowired
    public void set${entityName}Mapper(${entityName}Mapper ${entityName?uncap_first}Mapper) {
        this.${entityName?uncap_first}Mapper = ${entityName?uncap_first}Mapper;
        super.setMyBatisBaseDao(${entityName?uncap_first}Mapper);
    }

    @Override
    public List<${entityName}> search(${entityName}SearchDTO searchDTO) {
        return this.${entityName?uncap_first}Mapper.search(searchDTO);
    }

}
