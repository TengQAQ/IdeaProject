package com.hxzy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "测试模块")
@RestController
public class DemoController {

	@GetMapping(value = "/demo")
	@ApiOperation(value = "返回map数据类型")
	public Map mapJson(){
		Map map=new HashMap();
		map.put("id",1001);
		map.put("name","小张");
		return map;
	}

	@ApiOperation(value = "返回list数据类型")
	@GetMapping(value = "/list")
	public List listStu(int n){

		List arr=new ArrayList();
		for(int i=0;i<n;i++){
			Map map=new HashMap();
			map.put("id",1000+i);
			map.put("name","小张"+i);
			arr.add(map);
		}
		return arr;
	}

}
