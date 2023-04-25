package com.hxzy.controller.back;

import com.hxzy.common.controller.BaseController;
import com.hxzy.common.util.CommonDataUtil;
import com.hxzy.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/23-21:55
 * @description TODO
 */
@Api(tags = "数据字典API")
@RequestMapping(value = "/api/dict")
@RestController
public class DictDataController  extends BaseController {


    /**
     * /api/dict/bynames?dicts=b&dicts=c    return Qs.stringify(params, {arrayFormat: 'repeat'})
     * /api/dict/bynames?dicts=b,c          return Qs.stringify(params, {arrayFormat: 'comma'})
     * @param dicts
     * @return
     */
    @ApiOperation(value = "根据键查询值")
    @GetMapping(value = "/bynames")
    public Result findByDictName(String[] dicts){
        Map<String, List<Map<String,Object>>> map=new HashMap<>(dicts.length*3);
        for(String s :dicts){
            List<Map<String, Object>> result = CommonDataUtil.findByDictName(s);
            if(result!=null){
                map.put(s,result);
            }
        }
        return Result.okHasData(map);
    }

}