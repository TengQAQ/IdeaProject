package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.service.HxzyExamAdminUserTokenService;
import com.ming.service.impl.HxzyExamAdminUserTokenServiceImpl;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/api/userInfo")
public class UserInfoServlet extends HttpServlet {
	private Result result;
	private HxzyExamAdminUserTokenService service = new HxzyExamAdminUserTokenServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = req.getParameter("token");
		System.out.println("=================token"+token);
		if (token == null || token.trim().length() == 0) {
			result = Result.of(CodeEnum.ILLEGAL_TOKEN);
		} else {
			// 根据令牌查询用户信息
			result = service.selectByToken(token);
		}
		try (PrintWriter writer = resp.getWriter()) {
			writer.write(JSONObject.toJSONString(result));
			writer.flush();
		}
	}
}
