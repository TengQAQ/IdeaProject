package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.dto.UserLoginDto;
import com.hxzy.service.impl.HxzyExamAdminUserServiceImpl;
import com.hxzy.utils.RequestUtil;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/login")
public class UserLoginServlet extends HttpServlet {
    private final HxzyExamAdminUserServiceImpl service =  new HxzyExamAdminUserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserLoginDto dto = RequestUtil.post(req, UserLoginDto.class);
        // 获取访问当前servlet的ip地址
        String loginIp = req.getRemoteAddr();

        Result result = service.login(dto);
        try(PrintWriter writer = resp.getWriter()){
            writer.write(JSONObject.toJSONString(result));
            writer.flush();
        }
    }
}
