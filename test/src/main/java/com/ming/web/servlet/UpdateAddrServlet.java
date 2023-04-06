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

@WebServlet("/api/update")
public class UpdateAddrServlet extends HttpServlet {
	AddrInfoService service = new AddrInfoServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		AddrInfo of = RequestUtil.post(req, AddrInfo.class);
		System.out.println(of.toString());
		Result result = service.updateByPrimaryKeySelective(of);
		ResponseUtil.result2Client(resp,result);
	}
}
