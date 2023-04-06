package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.service.Impl.OccupationServiceImpl;
import com.hxzy.service.OccupationService;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/occupation")
public class OccupationServlet extends HttpServlet {
	private OccupationService service = new OccupationServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("Occupation");
		Result result = service.selectAll(name);
		String s = JSONObject.toJSONString(result);
		PrintWriter writer = resp.getWriter();
		writer.write(s);
		writer.flush();
		writer.close();
	}
}
