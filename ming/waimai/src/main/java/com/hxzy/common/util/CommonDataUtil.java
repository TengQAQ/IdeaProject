package com.hxzy.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/23-21:54
 * @description TODO
 */
public class CommonDataUtil {

    /**
     * 性别数据
     * @return
     */
    public static List<Map<String,Object>> genderData(){
        List<Map<String,Object>> arr=new ArrayList<>();
        Map<String,Object>  mp01=new HashMap<>();
        mp01.put("label","男");
        mp01.put("value",1);
        mp01.put("listClass","");

        Map<String,Object>  mp02=new HashMap<>();
        mp02.put("label","女");
        mp02.put("value",0);
        mp02.put("listClass","success");
        arr.add(mp02);
        arr.add(mp01);
        return arr;
    }



    /**
     * 状态（1停用，0正常）
     * @return
     */
    public static List<Map<String,Object>> statusData(){
        List<Map<String,Object>>  arr=new ArrayList<>();
        Map<String,Object>  mp01=new HashMap<>();
        mp01.put("label","停用");
        mp01.put("value",1);
        mp01.put("listClass","danger");

        Map<String,Object>  mp02=new HashMap<>();
        mp02.put("label","正常");
        mp02.put("value",0);
        mp02.put("listClass","");

        arr.add(mp02);
        arr.add(mp01);
        return arr;
    }

    /**
     * 简单工厂方法
     * @param dictName
     * @return
     */
    public static List<Map<String,Object>> findByDictName(String dictName){
        if(dictName.equals("sex")){
            return genderData();
        }else if(dictName.equals("status")){
            return statusData();
        }else{
            return null;
        }
    }

}
