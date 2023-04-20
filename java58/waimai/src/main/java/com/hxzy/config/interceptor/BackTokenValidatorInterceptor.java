package com.hxzy.config.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.hxzy.common.domain.TokenProperties;
import com.hxzy.common.enums.AckCode;
import com.hxzy.common.util.TokenUtil;
import com.hxzy.common.vo.R;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.vo.back.AdminLoginVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author wy
 * @Description 后台令牌验证拦截器
 * @Date 2023/4/6 11:19
 * @Version 1.0
 */
@Log4j2
@Component
public class BackTokenValidatorInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private TokenProperties tokenProperties;

    /**
     * 在执行Controller方法之后操作
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String jwtToken= request.getHeader( this.tokenProperties.getAdminHeader());

        //没有令牌
        if(StrUtil.isBlank(jwtToken)){
            R r=R.build(AckCode.TOKEN_NOT_BLANK);
            outJson(response,r);
            return false;
        }

        // 验证令牌有效性
        try {
            AdminLoginVO adminLoginVO = this.tokenUtil.verifyAdminToken(jwtToken);
            if (adminLoginVO == null) {
                R r = R.build(AckCode.TOKEN_FAIL);
                outJson(response, r);
                return false;
            }
            //如果令牌快过期了
            this.tokenUtil.refrshToken(adminLoginVO);

            //本次会话用户存起来，供本次后面的controller的方法使用
            WaimaiThreadLocal.adminThreadLocal.set(adminLoginVO);

        }catch(Exception e){
            log.error(e);
            R r = R.build(AckCode.APPLE_ILLEGAL);
            outJson(response, r);
            return false;
        }


        return  true;
    }

    /**
     * Controller方法执行完成以后的操作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       WaimaiThreadLocal.adminThreadLocal.remove();
    }

    private void outJson(HttpServletResponse response,R r){
        response.setCharacterEncoding("UTF-8");
        String json=JSONUtil.toJsonStr( r);
        ServletUtil.write(response,json,"application/json");

    }
}
