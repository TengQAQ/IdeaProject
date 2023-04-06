package com.hxzy.common.constants;

import cn.hutool.core.util.StrUtil;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-0:42
 * @description TODO
 */
public class RedisConstant {
    /**
     * 后台验证码key
     */
    public static final String   CAPTCHA_KEY="back:captcha:";

    /**
     * 5分钟
     */
    public static final Integer FIVE_MINUTES=5;


    /**
     * 拼接完整的redis的key
     * @param prefix
     * @param uuid
     * @return
     */
    public static  String getRedisKey(String prefix,String uuid){
        if(StrUtil.isBlank(uuid)){
            return prefix;
        }
        return  prefix+ uuid;
    }

    /**
     * 拼接完整的redis的key
     * @param prefix
     * @return
     */
    public static  String getRedisKey(String prefix){
        return getRedisKey(prefix,null);
    }
}
