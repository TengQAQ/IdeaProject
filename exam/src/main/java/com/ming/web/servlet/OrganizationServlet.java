package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.Dto.OrgDto;
import com.ming.service.impl.OrganizationService;
import com.ming.service.impl.OrganizationServiceImpl;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/org")
public class OrganizationServlet extends HttpServlet {
	private final OrganizationService service = new OrganizationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.selectAll();
		String jsonString = JSONObject.toJSONString(result);
		try (PrintWriter writer = resp.getWriter()) {
			writer.write(jsonString);
			writer.flush();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (BufferedReader reader = req.getReader()) {
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			String json = builder.toString();

			OrgDto orgDto = JSONObject.parseObject(json, OrgDto.class);
			System.out.println("orgDto =======================" + orgDto);
			// 实现新增
//			Result result = this.service.insert(orgDto);
//
//			String s = JSONObject.toJSONString(result);
//
//			try (PrintWriter writer = resp.getWriter()) {
//				writer.write(s);
//				writer.flush();
//			}
		}
	}
}
