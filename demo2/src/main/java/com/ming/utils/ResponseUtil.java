package com.ming.utils;

import com.alibaba.fastjson2.JSONObject;
import com.ming.vo.Result;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {
	/**
	 * 将Result对象转换为json后输出到客户端
	 * @param resp
	 * @param result
	 */
	public static void result2Client(HttpServletResponse resp, Result result) {
		if (result == null) {
			throw new RuntimeException("参数result不能为空");
		}
		String jsonString = JSONObject.toJSONString(result);
		try (PrintWriter writer = resp.getWriter()) {
			writer.write(jsonString);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
