package com.hxzy.config;

import com.hxzy.vo.back.AdminLoginVO;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/7-1:23
 * @description TODO
 */
public class WaimaiThreadLocal {
    /**
     * 存放后台用户验证令牌后的数据 本地线程
     */
    public static ThreadLocal<AdminLoginVO>  adminThreadLocal=new ThreadLocal<>();
}
