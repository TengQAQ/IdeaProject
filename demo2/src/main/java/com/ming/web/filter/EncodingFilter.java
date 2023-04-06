package com.ming.web.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(urlPatterns = {"/api/*"},
			initParams = {@WebInitParam(name = "Encode", value = "utf-8")})
public class EncodingFilter implements Filter {
	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("Encode");
		System.out.println("==================ENCODING拦截器已启动");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
		servletRequest.setCharacterEncoding(this.encoding);
		servletResponse.setCharacterEncoding(this.encoding);
//		System.out.println(encoding);
		filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {
		System.out.println("==================ENCODING拦截器已结束");
	}
}
