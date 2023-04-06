package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.mapper.Impl.OtherMapperImpl;
import com.hxzy.service.Impl.OtherServiceImpl;
import com.hxzy.service.OtherService;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/search")
public class SearchServlet extends HttpServlet {
	private OtherService service = new OtherServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
			String table = req.getParameter("tableName");
		Result result = service.selectByTable(table);
		String s = JSONObject.toJSONString(result);
		PrintWriter writer = resp.getWriter();
		writer.write(s);
		writer.flush();
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
