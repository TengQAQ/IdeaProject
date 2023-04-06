package com.ming.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(urlPatterns = {"/api/*"},
		initParams = {@WebInitParam(name = "contentType", value = "application/json;charset=utf-8")})
public class JsonFilter implements Filter {
	private String contentType;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.contentType = filterConfig.getInitParameter("contentType");
		System.out.println("==================Josn拦截器已启动");
//		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("-------------JsonFilter已拦截到请求----------------");
		// 为所有以/api开头的请求设置响应头
		response.setContentType(this.contentType);
		// 放行请求
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("==================Json拦截器已结束");
//		Filter.super.destroy();
	}
}
