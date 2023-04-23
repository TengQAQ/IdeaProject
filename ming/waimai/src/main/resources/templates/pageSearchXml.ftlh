
<select id="search"  resultMap="BaseResultMap">
    select
    <#if tableFieldList??>
        <#list tableFieldList as column>
           ${column.columnName}
            <#if column_has_next>
               ,
            </#if>
        </#list>
    <#else>
       ${allFields}
    </#if>

    from ${oracleTableName}

    <#if searchParams??>
    <where>
         <#list searchParams as params>
             <#if params.javaDataType=="String">
                 <if test="dto.${params.javaField}!=null and dto.${params.javaField}!=''">
                     and ${params.columnName} like  concat( concat('%',${r'#'}{dto.${params.javaField} }),'%')
                 </if>
             <#else>
                 <if test="dto.${params.javaField}!=null">
                     and ${params.columnName}  =  ${r'#'}{dto.${params.javaField} }
                 </if>
             </#if>
         </#list>

    </where>
    </#if>


</select>