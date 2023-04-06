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

@WebServlet("/api/addAddr")
public class AddAddrServlet extends HttpServlet {
	private AddrInfoService service = new AddrInfoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddrInfo addrInfo = RequestUtil.post(req, AddrInfo.class);
		System.out.println("========="+addrInfo);
		System.out.println(addrInfo.toString());
		Result result = service.insertSelective(addrInfo);
		ResponseUtil.result2Client(resp,result);
	}

}
