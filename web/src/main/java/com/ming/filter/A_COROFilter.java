package com.ming.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/api/*"})
public class A_COROFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("==================CORO拦截器已启动");
//		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		//拦截器允许跨域同源
		// 服务器允许任何域名跨域访问
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Credentials", "true"); //允许携带cookie
		resp.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept,mid,X-Token"); // 允许携带的自定义的请求头

		String method = req.getMethod(); // 获取请求方法
		if (method.equals("OPTIONS")) {
			// 先放行,执行servlet中的service方法
			filterChain.doFilter(servletRequest,servletResponse);
			// servlet中重写doXxx方法，则通过allow去获取
			String allow = resp.getHeader("Allow");
			// 告诉浏览器，后端服务器支持的请求方法
			resp.setHeader("Access-Control-Allow-Methods", allow);
		} else {
			filterChain.doFilter(servletRequest,servletResponse);
		}
	}

	@Override
	public void destroy() {
//		Filter.super.destroy();
		System.out.println("==================CORO拦截器已结束");
	}
}
