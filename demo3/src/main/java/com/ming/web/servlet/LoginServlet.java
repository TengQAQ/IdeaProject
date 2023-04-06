package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.dto.UserLoginDto;
import com.ming.service.HrService;
import com.ming.service.impl.HrServiceImpl;
import com.ming.util.RequestUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
	HrService service = new HrServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserLoginDto dto = RequestUtil.post(req, UserLoginDto.class);
		System.out.println(dto.toString());
		// 获取访问当前servlet的ip地址
		String loginIp = req.getRemoteAddr();
		dto.setLoginIp(loginIp);
		Result result = service.login(dto);
		try(PrintWriter writer = resp.getWriter()){
			writer.write(JSONObject.toJSONString(result));
			writer.flush();
		}
	}
}
