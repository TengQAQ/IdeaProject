package com.ming.util;


import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.Objects;

public class RequestUtil {
	/**
	 * 将url参数中封装为一个指定类型的对象
	 * @param req
	 * @param tClass
	 * @param <T>
	 * @return
	 */
	public static <T> T of(HttpServletRequest req, Class<T> tClass) {
		// 利用jsonObject将一个map集合转换为java对象
		JSONObject jsonObject = new JSONObject();
		// 从request请求中获取所有的url参数名
		Enumeration<String> parameterNames = req.getParameterNames();
		// 类似于一个迭代器
		while (parameterNames.hasMoreElements()) {
			// 得到参数名
			String key = parameterNames.nextElement();
			// 从request中根据参数名获取值
			String parameter = req.getParameter(key);
			System.out.println(key + " --------------------->" + parameter);
			// 将url参数以及值插入到map集合
			jsonObject.put(key, parameter);
		}
		return jsonObject.to(tClass);
	}
}