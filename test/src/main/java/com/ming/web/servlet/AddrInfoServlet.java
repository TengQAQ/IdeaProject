package com.ming.web.servlet;

import com.ming.service.AddrInfoService;
import com.ming.service.impl.AddrInfoServiceImpl;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/allAddr")
public class AddrInfoServlet extends HttpServlet {
	private AddrInfoService service = new AddrInfoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		EmpDto empDto = RequestUtil.post(req, EmpDto.class);
//		System.out.println(empDto.toString());
		Result result = service.allAddrInfo();
		ResponseUtil.result2Client(resp,result);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Result result = service.allAddrInfo();
		ResponseUtil.result2Client(resp,result);
	}
}
