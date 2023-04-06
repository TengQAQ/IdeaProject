package com.xuefeng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/api/*"},
        initParams = {@WebInitParam(name = "contentType", value = "application/json")
}
)
public class JsonFilter implements Filter {
    private String contentType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.contentType = filterConfig.getInitParameter("contentType");
        System.out.println("-----------JsonFilter.init-------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("-----------JsonFilter.doFilter-------------");
        response.setContentType(this.contentType);
        chain.doFilter(request,response);
        System.out.println("-----------JsonFilter.doFilter()执行完毕------------");
    }

    @Override
    public void destroy() {
        System.out.println("-------------JsonFilter.destroy()---------------");
    }
}
