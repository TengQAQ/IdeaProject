package com.hxzy.controller.back;

import com.hxzy.common.constants.RedisConstant;
import com.hxzy.common.constants.WaiMaiConstant;
import com.hxzy.common.domain.CaptchaProperties;
import com.hxzy.vo.Result;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-0:34
 * @description TODO
 */
@Api(tags = "验证码模块")
@RestController
@RequestMapping(value = "/api")
public class CaptchaController {


    /**
     * redis操作的模板类
     */
    @Autowired
    @ApiModelProperty("redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 自动装配验证码的配置文件
     */
    @Autowired
    private CaptchaProperties captchaProperties;

    @GetMapping(value = "/captcha")
    @ApiOperation("获取验证码")
    public Result captcha(){
        //多态    工厂方法  https://blog.csdn.net/qq_25827845/article/details/52503884
        Captcha captcha=null;

        if(WaiMaiConstant.PNG.equals(this.captchaProperties.getType())){
            captcha=new SpecCaptcha(this.captchaProperties.getWidth(), this.captchaProperties.getHeight());
            captcha.setLen(this.captchaProperties.getLen());
        }else if(WaiMaiConstant.GIF.equals(this.captchaProperties.getType())){
            captcha=new GifCaptcha(this.captchaProperties.getWidth(), this.captchaProperties.getHeight());
            captcha.setLen(this.captchaProperties.getLen());
        }else{
            captcha= new ArithmeticCaptcha(this.captchaProperties.getWidth(), this.captchaProperties.getHeight());
            captcha.setLen(this.captchaProperties.getLen());
        }
        //验证码的结果
        String value = captcha.text();
        //令牌
        String uuid= UUID.randomUUID().toString();
        //存放到redis中 "back:captcha:"+uuid
        String redisKey= RedisConstant.getRedisKey(RedisConstant.CAPTCHA_KEY,uuid);

        //存入到redis，5分钟过期
        this.redisTemplate.opsForValue().set(redisKey, value,RedisConstant.FIVE_MINUTES, TimeUnit.MINUTES);

        //返回给前端
        Map<String,String> map=new HashMap<>(16);
        map.put("uuid",uuid);
        map.put("image", captcha.toBase64());

        return Result.okHasData(map);
    }


}