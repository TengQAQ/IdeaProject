package com.ming.web.filter;

import com.ming.service.UserInfoService;
import com.ming.service.impl.UserInfoServiceImpl;
import com.ming.util.JedisPoolUtils;
import com.ming.util.ResponseUtil;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Arrays;

@WebFilter(urlPatterns = {"/api/*"})
public class TokenFilter implements Filter {
	// 定义不需要被拦截的白名单
	private final String[] whiteList = {"/api/login"};

	private UserInfoService service = new UserInfoServiceImpl();

	// 业务逻辑层
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("=======================TokenFilter启动");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 用户请求的servlet的path路径
		String requestURI = req.getRequestURI();
		// /demo2/api/login  /demo2/api/elementary
		// /项目上下文/servlet的path
		// System.out.println("==================" + requestURI);

		// 获取当前项目的发布路径（tomcat中的deployment中的路径）
		String contextPath = req.getContextPath(); // /demo2
		// 校验requestURI是否在白名单之内
		long count = Arrays.stream(whiteList)
				.filter(path -> contextPath.concat(path).equals(requestURI))
				.count();
		if (count > 0) { // 请求的url在白名单之内
			// 放行请求
			chain.doFilter(req,resp);
			return;
		}

		// 1.从请求头中获取X-Token
		String token = req.getHeader("X-Token");

		Result result = null;
		if (token == null || token.trim().length() == 0) { // 请求头中没有X-Token
			// 指定非法令牌的响应信息
			result = Result.of(CodeEnum.ILLEGAL_TOKEN);
		} else { // 有X-Token
			// 根据令牌查询用户登录记录
//			访问数据库
//			HxzyExamAdminUserToken userLogin = mapper.selectByToken(token);
//			if (userLogin == null) { // 数据库没有该令牌的登录信息
//                // 指定非法令牌的响应信息
//                result = Result.of(CodeEnum.ILLEGAL_TOKEN);
//            } else { // 有该令牌的登录信息
//                long current = System.currentTimeMillis(); // 得到系统当前时间
//                if (userLogin.getExpireTime().compareTo(new Date(current)) <= 0) { // 令牌过期
//                    // 指定非法令牌的响应信息
//                    result = Result.of(CodeEnum.TOKEN_EXPIRED);
//                } else { // 令牌有效
//                    // 放行请求
//                    chain.doFilter(req, resp);
//                    return; // 正常情况，令牌有效，则不需要在此处的过滤器响应数据给客户端
//                }
//            }

//			访问redis
			try (Jedis jedis = JedisPoolUtils.getJedis()) {
				String key = "user:token:" + token;
				// 如果根据键取到值则返回，如果没有值则返回nil
				String realToken = jedis.get(key);
				System.out.println("key = " + key + ",\t从redis中取到的值 = " + realToken);
				if (realToken != null) {
					// 放行请求
					chain.doFilter(req, resp);
					return; // 正常情况，令牌有效，则不需要在此处的过滤器响应数据给客户端
				} else {
					// 令牌无效或者令牌过期
					result = Result.of(CodeEnum.TOKEN_EXPIRED);
				}
			}
		}
		ResponseUtil.result2Client(resp, result);
	}

	@Override
	public void destroy() {

	}
}
