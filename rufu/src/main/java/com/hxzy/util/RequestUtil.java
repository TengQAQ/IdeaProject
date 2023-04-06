package com.hxzy.util;


import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

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

	/**
	 * 从请求体中获取提交的json，并将json转换为class类的对象
	 * @param req
	 * @param tClass
	 * @param <T>
	 * @return
	 */
	public static <T> T post(HttpServletRequest req, Class<T> tClass) {
		try(BufferedReader reader = req.getReader()) {
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			// 得到json
			String json = builder.toString();
			// 将json转换为java对象
			return JSONObject.parseObject(json, tClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}