package com.hxzy.common.easyexcel;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.hxzy.common.util.CommonDataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author wy
 * @Description 状态转换
 * @Date 2023/4/15 17:02
 * @Version 1.0
 */
public class StatusConverter implements Converter<Short> {
    public StatusConverter() {
    }


    /**
     * 判断java支持的数据类型
     * @return
     */
    @Override
    public Class<?> supportJavaTypeKey() {
        return  Short.class;
    }

    /**
     * 把excel表中的数据值，转换成java类型
     * excel=男    转换java gender=1
     * @param cellData
     * @param contentProperty
     * @param globalConfiguration
     * @return
     * @throws Exception
     */
    @Override
    public Short convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return Converter.super.convertToJavaData(cellData, contentProperty, globalConfiguration);
    }

    /**
     * 把java的值转换成，写入到excel表中
     * 把 java=1    转换为excel=男
     * @param value
     * @param contentProperty
     * @param globalConfiguration
     * @return
     * @throws Exception
     */
    @Override
    public WriteCellData<?> convertToExcelData(Short value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        int v=value.intValue();
        //得到数据
        List<Map<String, Object>> mapList = CommonDataUtil.statusData();
        List<Map<String, Object>> maps = mapList.stream().filter(p -> Integer.parseInt(p.get("value").toString()) == v).collect(Collectors.toList());
        if(maps.isEmpty()){
            return new WriteCellData<>("");
        }else{
            String str=maps.get(0).get("label").toString();
            return new WriteCellData<>(str);
        }
    }
}
