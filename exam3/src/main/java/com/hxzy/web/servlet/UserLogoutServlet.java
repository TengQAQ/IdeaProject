package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.service.HxzyExamAdminUserTokenService;
import com.hxzy.service.impl.HxzyExamAdminUserTokenServiceImpl;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/logout")
public class UserLogoutServlet extends HttpServlet {
    private final HxzyExamAdminUserTokenService service = new HxzyExamAdminUserTokenServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求头中获取token
        String token = req.getHeader("X-Token");
        System.out.println("退出登录，接收到的令牌：" + token);
        if (token != null) {
            Result result = service.logOut(token);
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(JSONObject.toJSONString(result));
                writer.flush();
            }
        }
    }
}

