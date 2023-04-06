package com.hxzy.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWTUtil;
import com.hxzy.common.constants.RedisConstant;
import com.hxzy.common.vo.back.LoginVO;
import com.hxzy.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-10:43
 * @description TODO
 */
@Component
public class TokenUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 自定义令牌配置信息
     */
    @Autowired
    private TokenProperties tokenProperties;


    /**
     * 自定义对象，换取令牌(uuid)-->jwt
     *         // 把 employee--> AdminLoginVO
     *         // 把 AdminLoginVO--> uuid -->存到redis中(string数据类型)
     *         // uuid-->换成jwt加密码  https://hutool.cn/docs/#/jwt/JWT%E5%B7%A5%E5%85%B7-JWTUtil
     * @param employee
     * @return
     */
    public String createJwtToken(Emp employee) {
        //组装成自定义的对象
        LoginVO adminLoginVO=new LoginVO();
        adminLoginVO.setId(employee.getId());
        adminLoginVO.setName(employee.getLoginName());
        adminLoginVO.setAvatar(employee.getAvatar());
        adminLoginVO.setAccountType(1);

        //令牌
        adminLoginVO.setToken(UUID.randomUUID().toString());
        //过期时间
        adminLoginVO.setExpiredTime( DateUtil.offsetMinute(new Date(), this.tokenProperties.getExpiredMinutes()));

        //存储到redis中
        String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getAdminRedisPrefix()+ adminLoginVO.getToken());
        this.redisTemplate.opsForValue().set(redisKey, adminLoginVO, this.tokenProperties.getExpiredMinutes(), TimeUnit.MINUTES);

        // uuid--> jwt加密   https://hutool.cn/docs/#/jwt/JWT%E5%B7%A5%E5%85%B7-JWTUtil
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("uuid",  adminLoginVO.getToken());
            }
        };

        String jwtToken = JWTUtil.createToken(map, this.tokenProperties.getSign().getBytes());
        return jwtToken;
    }

    /**
     * 向redis中写入数据(刷新操作)
     * @param adminLoginVO
     */
    public void refrshToken(LoginVO adminLoginVO){

        //判断，令牌是否快要过期了    未来时间毫秒 -  当前时间毫秒 <= 还有20分钟 毫秒
        long future=adminLoginVO.getExpiredTime().getTime();
        long now=System.currentTimeMillis();

        if(future - now <= this.tokenProperties.getRefreshToken()){
            adminLoginVO.setExpiredTime( DateUtil.offsetMinute(new Date(), this.tokenProperties.getExpiredMinutes()));
            //存储到redis中
            String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getAdminRedisPrefix()+ adminLoginVO.getToken());
            this.redisTemplate.opsForValue().set(redisKey, adminLoginVO, this.tokenProperties.getExpiredMinutes(),TimeUnit.MINUTES);
        }
    }

}
