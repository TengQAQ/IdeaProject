package com.ming.web.servlet;

import com.ming.service.PoliticsstatusService;
import com.ming.service.impl.PoliticsstatusServiceImpl;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/polit")
public class PoliticsstatusServlet extends HttpServlet {
	private PoliticsstatusService service = new PoliticsstatusServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.allPoliticsstatus();
		ResponseUtil.result2Client(resp,result);
	}
}
