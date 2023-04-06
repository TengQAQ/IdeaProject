package com.xuefeng.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 服务器启动时，就会初始化过滤器并托管到容器
 */
public class EncodingFilter implements Filter {
    private String encode;
    /**
     * 服务器启动时，初始了过滤器之后执行的方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取初始参数
        this.encode = filterConfig.getInitParameter("encode");
        System.out.println("-------------EncodingFilter.init()---------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("-------------EncodingFilter.doFilter()---------------");
        // 设置请求编码
        request.setCharacterEncoding(this.encode);
        // 设置响应编码
        response.setCharacterEncoding(this.encode);
        // 放行过滤器，让过滤器进入下一道过滤器
        chain.doFilter(request, response);
        System.out.println("-----------EncodingFilter.doFilter()执行完毕------------");
    }

    /**
     * 当服务器重启或关闭时，销毁过滤器时执行的方法
     */
    @Override
    public void destroy() {
        System.out.println("-------------EncodingFilter.destroy()---------------");
    }
}
