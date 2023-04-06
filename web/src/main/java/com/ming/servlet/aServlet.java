package com.ming.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/a")
public class aServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("一个a servlet 请求已经被接收");
		Map<String,String> map = new HashMap();
		map.put("time",System.currentTimeMillis() + "");
		map.put("ref","bServlet");

		req.setAttribute("map",map);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/b");

		System.out.println("页面即将跳转");

		dispatcher.forward(req,resp);
	}
}
