package com.ming.web.servlet;

import com.ming.mapper.HxzyExamProductMapper;
import com.ming.service.HxzyExamProductService;
import com.ming.service.impl.HxzyExamProductServiceImpl;
import com.ming.utils.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/product")
public class selectProduct extends HttpServlet {
	private HxzyExamProductService service = new HxzyExamProductServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.selectAll();
		ResponseUtil.result2Client(resp,result);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.selectAll();
		ResponseUtil.result2Client(resp,result);
	}
}
