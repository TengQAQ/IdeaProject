package com.hxzy.vo.back;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-13:07
 * @description TODO
 */
public class TableNameColumnsVO {
    private Long num;
    private String columnName;
    private String dataType;
    private BigDecimal dataLength;

    /**
     * 在vue中显示的列名
     */
    private String comments;

    /**
     * java的列名
     */
    private String javaField;

    /**
     * 按照驼峰命名法
     * @return
     */
    public String getJavaField() {
        if(StrUtil.isNotBlank(javaField)){
            return this.javaField;
        }
        int index=this.columnName.indexOf(CharUtil.UNDERLINE);
        if(index>=0){
            return  StrUtil.toCamelCase(this.columnName);
        }

        return this.columnName.toLowerCase(Locale.ROOT);
    }

    /**
     * oracle数据类转换成java
     * @return
     */
    public String getJavaDataType() {

        if(StrUtil.isNotBlank(this.javaDataType)){
            return this.javaDataType;
        }

        //数字
        if(this.dataType.equalsIgnoreCase("NUMBER")){
            //如果不指定number的长度，或指定长度n>18
            if(this.dataLength.intValue()>18) {
                return BigDecimal.class.getSimpleName();
            }else if(this.dataLength.intValue()>=10){
                //10 <= n <= 18
                return Long.class.getSimpleName();
            }else if(this.dataLength.intValue()>=5){
                return Integer.class.getSimpleName();
            }else{
                return Short.class.getSimpleName();
            }
        }else if(this.dataType.equalsIgnoreCase("DATE")){
            return Date.class.getSimpleName();
        }else{
            return String.class.getSimpleName();
        }
    }

    /**
     * java的数据类型
     */
    private String javaDataType;

    /**
     * vue显示表格列的类型(1、文本，2、自定义转换的值)
     * 文本  <el-table-column prop="userName" label="昵称" width="180" ></el-table-column>
     * 自定义转换、   <el-tag v-if="scope.row.gender===1" type="primary">男</el-tag>
     *           <el-tag v-else type="success">女</el-tag>
     */
    private Long vueType=1L;

    /**
     * vue表格自定义转换值的配置 ( 0=男:1=女 )
     */
    private String  convertValue;

    /**
     * 是否为查询字段
     */
    private Boolean searchField;

    /**
     * 是否是表格要显示字段
     */
    private Boolean tableField;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<Map<String,Object>> convertList;

    public List<Map<String, Object>> getConvertList() {
        if(StrUtil.isBlank(this.convertValue)){
            return null;
        }

        //0=女:1=男
        if(this.vueType==3){
            String[] splitArr=this.convertValue.split(":");
            List<Map<String, Object>>  mapList=new ArrayList<>();
            for(String value : splitArr){
                String[] valueArr=value.split("=");

                Map<String,Object> mp=new HashMap<>();
                mp.put("key", valueArr[0]);
                mp.put("value",valueArr[1]);
                mapList.add(mp);
            }
            return mapList;
        }
        return null;
    }
}
