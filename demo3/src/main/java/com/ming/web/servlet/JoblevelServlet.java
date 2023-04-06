package com.ming.web.servlet;

import com.ming.service.JoblevelService;
import com.ming.service.impl.JoblevelServiceImpl;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/job")
public class JoblevelServlet extends HttpServlet {
	JoblevelService service = new JoblevelServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.allJoblevel();
		ResponseUtil.result2Client(resp,result);
	}
}
