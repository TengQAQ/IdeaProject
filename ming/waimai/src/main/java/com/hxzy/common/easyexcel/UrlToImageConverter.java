package com.hxzy.common.easyexcel;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wy
 * @Description url转换成二进制，二进制流转换excel image
 * @Date 2023/4/15 17:45
 * @Version 1.0
 */
public class UrlToImageConverter implements Converter<String> {

    public UrlToImageConverter() {
    }

    public Class<?> UrlToImageConverter() {
        return String.class;
    }

    @Override
    public WriteCellData<?> convertToExcelData(String value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        // value --> http 请求 --> InputStream-->写入到 byteInputStream-->toArray[]
        //https://waimai-1300180953.cos.ap-chongqing.myqcloud.com/images/168e72d8-f6da-444b-94a2-dc2a084f2148.png
        // get请求 --> 流 --> byte[]
        if(StrUtil.isBlank(value)){
            return new WriteCellData<>("没有图片");
        }

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<byte[]> forEntity = restTemplate.getForEntity(value, byte[].class);
        //图片 访问OK
        if(forEntity.getStatusCode()== HttpStatus.OK){
            byte[] body = forEntity.getBody();
            //写入图片
            return new WriteCellData<>(body);
        }else{
            return new WriteCellData<>("图片访问失败");
        }

    }




}


