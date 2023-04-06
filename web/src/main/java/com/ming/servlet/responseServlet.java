package com.ming.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class responseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("response接收到请求");
		resp.setCharacterEncoding("utf-8");
		resp.setStatus(200);
		resp.setHeader("content-type","text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<head>");
		writer.write("<title>");
		String title = "基于servlet实现的页面";
		writer.print(title);
		writer.write("</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("<h1>大家都喜欢的水果</h1>");
		String[] fruits = {"苹果","香蕉","西瓜","哈密瓜"};
		writer.write("<ul>");
		for (String fruit : fruits) {
			writer.write("<li>"+fruit+"</li>");
		}
		writer.write("</ul>");
		writer.write("</body>");
		writer.write("</html>");

		// 刷新输出流
		writer.flush();
		// 流用完后需要关闭
		writer.close();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public String getServletInfo() {
		return super.getServletInfo();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
}
