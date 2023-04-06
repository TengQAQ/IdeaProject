package com.ming.web.servlet;

import com.ming.entity.AddrInfo;
import com.ming.service.AddrInfoService;
import com.ming.service.impl.AddrInfoServiceImpl;
import com.ming.util.RequestUtil;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/deleteAddr")
public class DeleteAddr extends HttpServlet {
	private AddrInfoService service = new AddrInfoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s = RequestUtil.post(req, String.class);
		System.out.println("========="+s);
		Result result = service.deleteByPrimaryKey(Integer.valueOf(s));
		ResponseUtil.result2Client(resp,result);
	}

}