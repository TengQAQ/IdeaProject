package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.service.HusbandService;
import com.hxzy.service.Impl.HusbandServiceImpl;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/hus")
public class HusbandServlet extends HttpServlet {
	private HusbandService service =new HusbandServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		String json = builder.toString();
		System.out.println("json"+json);
		Result result = service.selectByPrimaryKey(Long.valueOf(json));
		System.out.println(result.toString());
		String jsonString = JSONObject.toJSONString(result);
		System.out.println(jsonString);

		PrintWriter writer = resp.getWriter();
		writer.write(jsonString);
		writer.flush();
		writer.close();
	}
}
