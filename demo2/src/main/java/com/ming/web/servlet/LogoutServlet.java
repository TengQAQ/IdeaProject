package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.service.HxzyExamAdminUserTokenService;
import com.ming.service.impl.HxzyExamAdminUserTokenServiceImpl;
import com.ming.vo.Result;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/logout")
public class LogoutServlet extends HttpServlet {
    private final HxzyExamAdminUserTokenService service = new HxzyExamAdminUserTokenServiceImpl();
    private Result result;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 从请求头中获取token
        String token = req.getHeader("X-Token");
        System.out.println("退出登录，接收到的令牌：" + token);
        if (token != null) {
            result = service.logOut(token);
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(JSONObject.toJSONString(result));
                writer.flush();
            }
        }
    }
}

