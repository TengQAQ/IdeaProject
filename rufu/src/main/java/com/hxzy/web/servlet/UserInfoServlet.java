package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.entity.UserLogin;
import com.hxzy.mapper.Impl.UserLoginMapperImpl;
import com.hxzy.mapper.UserLoginMapper;
import com.hxzy.service.Impl.UserLoginServiceImpl;
import com.hxzy.service.UserLoginService;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/userInfo")
public class UserInfoServlet extends HttpServlet {
	private final UserLoginService service = new UserLoginServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从request请求参数中获取token
		String token = req.getParameter("token");

		Result result = null;
		if (token == null || token.trim().length() == 0) {
			result = Result.of(CodeEnum.ILLEGAL_TOKEN);
		} else {
			// 根据令牌查询用户信息
			result = service.getUserInfoByToken(token);
		}
		try(PrintWriter writer = resp.getWriter()){
			String jsonString = JSONObject.toJSONString(result);
			writer.write(jsonString);
			writer.flush();
		}
	}
}
