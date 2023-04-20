package com.hxzy.common.constants;

import cn.hutool.core.util.StrUtil;

/**
 * @Author wy
 * @Description 存储redis的常量
 * @Date 2023/4/4 15:02
 * @Version 1.0
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
     * 短信的redis前缀
     */
    public static final String SMS_REDIS_KEY="sms:";

    /**
     * 商家注册短信的redis前缀
     */
    public static final String SMS_SHOP_REGISTER_REDIS_KEY="sms:shop:register:";





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
