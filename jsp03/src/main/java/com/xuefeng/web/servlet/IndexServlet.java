package com.xuefeng.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---------IndexServlet.doGet()------------");
        String name = req.getParameter("name");

        String json = "{\"message\":\"操作成功\",\"code\":20000,\"data\":\"" + name + "\"}";
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            writer.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
