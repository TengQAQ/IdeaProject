package com.hxzy.config;

import com.hxzy.vo.back.AdminLoginVO;
import com.hxzy.vo.front.MobileLoginVO;

/**
 * @Author wy
 * @Description 本地线程池
 * @Date 2023/4/6 11:51
 * @Version 1.0
 */
public class WaimaiThreadLocal {

    /**
     * 存放后台用户验证令牌后的数据 本地线程
     */
    public static ThreadLocal<AdminLoginVO>  adminThreadLocal=new ThreadLocal<>();


    /**
     * 存放mobile用户验证令牌后的数据 本地线程
     */
    public static ThreadLocal<MobileLoginVO>  mobileThreadLocal=new ThreadLocal<>();
}
