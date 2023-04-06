package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.service.HxzyExamAdminUserTokenService;
import com.hxzy.service.impl.HxzyExamAdminUserTokenServiceImpl;
import com.hxzy.vo.CodeEnum;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/userInfo")
public class UserInfoServlet extends HttpServlet {
    private final HxzyExamAdminUserTokenService service = new HxzyExamAdminUserTokenServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从request请求参数中获取token
        String token = req.getParameter("token");

        Result result;
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
