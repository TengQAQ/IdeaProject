package com.ming.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/test")
public class testServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		req.setCharacterEncoding("utf-8");
//		resp.setCharacterEncoding("utf-8");
		// 设置服务器响应的数据类型
//		resp.setContentType("application/json");
//		resp.setContentType("text/json; charset=utf-8");
//		resp.setHeader("Access-Control-Allow-Origin", "*");

		System.out.println("获取到testservlet");

		String json = "[{\"id\":1,\"name\":\"张三1\",\"age\":21},{\"id\":2,\"name\":\"张三2\",\"age\":22},{\"id\":3,\"name\":\"张三3\",\"age\":23},{\"id\":4,\"name\":\"张三4\",\"age\":24},{\"id\":5,\"name\":\"张三5\",\"age\":25}]";
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
