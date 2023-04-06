package com.ming.web.servlet;

import com.ming.service.NationService;
import com.ming.service.impl.NationServiceImpl;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/nation")
public class NationServlet extends HttpServlet {
	private NationService service = new NationServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.allNation();
		ResponseUtil.result2Client(resp,result);
	}
}
