package com.hxzy.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.hxzy.common.constants.RedisConstant;
import com.hxzy.common.domain.TokenProperties;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.entity.Contamer;
import com.hxzy.entity.Employee;
import com.hxzy.vo.back.AdminLoginVO;
import com.hxzy.vo.front.MobileLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author wy
 * @Description 令牌管理工具类
 * @Date 2023/4/4 17:14
 * @Version 1.0
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
     * @param adminLoginVO
     * @return
     */
    public String createJwtToken( AdminLoginVO adminLoginVO) {

        //令牌
        adminLoginVO.setToken(UUID.randomUUID().toString());
        //过期时间
        adminLoginVO.setExpiredTime( DateUtil.offsetMinute(new Date(), this.tokenProperties.getExpiredMinutes()));

        //存储到redis中
        String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getAdminRedisPrefix()+ adminLoginVO.getToken());
        this.redisTemplate.opsForValue().set(redisKey, adminLoginVO, this.tokenProperties.getExpiredMinutes(),TimeUnit.MINUTES);

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
    public void refrshToken(AdminLoginVO adminLoginVO){

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

    /**
     * 验证后台令牌的有效性
     * @param jwtToken
     * @return
     */
    public AdminLoginVO  verifyAdminToken(String jwtToken){
          String jwt=parseToken(jwtToken);
          //解析jwt
          if( JWTUtil.verify(jwt, this.tokenProperties.getSign().getBytes())){
              final JWT jwtObject= JWTUtil.parseToken(jwt);
              String uuid=jwtObject.getPayload("uuid").toString();
               //构造一个redisKey
              String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getAdminRedisPrefix()+uuid);
              Object redisValue=this.redisTemplate.opsForValue().get(redisKey);
              if(redisValue!=null){
                  return (AdminLoginVO) redisValue;
              }
          }
          return null;
    }

    /**
     * 解析令牌 ,判断它是否拥有 Bearer 开头值
     * @param jwtToken
     * @return
     */
    public String parseToken(String jwtToken){
        if(jwtToken.startsWith(this.tokenProperties.getAdminBear())){
            jwtToken=jwtToken.replace(this.tokenProperties.getAdminBear(),"").trim();
        }
        return jwtToken;
    }

    /**
     * 后台用户退出
     * 移出redis的信息
     */
    public void backLogout() {
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();
        String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getAdminRedisPrefix()+ adminLoginVO.getToken());
        this.redisTemplate.delete(redisKey);
    }


    /**
     * 创建手机端
     * @param entity
     * @return
     */
    public String createMobileJwtToken( MobileLoginVO entity) {

        //令牌
        entity.setToken(UUID.randomUUID().toString());
        //过期时间
        entity.setExpiredTime( DateUtil.offsetMinute(new Date(), this.tokenProperties.getExpiredMinutes()));

        //存储到redis中
        String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getMobileRedisPrefix()+ entity.getToken());
        this.redisTemplate.opsForValue().set(redisKey, entity, this.tokenProperties.getExpiredMinutes(),TimeUnit.MINUTES);

        // uuid--> jwt加密   https://hutool.cn/docs/#/jwt/JWT%E5%B7%A5%E5%85%B7-JWTUtil
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("uuid",  entity.getToken());
            }
        };

        String jwtToken = JWTUtil.createToken(map, this.tokenProperties.getSign().getBytes());
        return jwtToken;
    }

    /**
     * mobile用户退出
     * 移出redis的信息
     */
    public void  mobileLogout() {
        MobileLoginVO  loginVO = WaimaiThreadLocal.mobileThreadLocal.get();
        String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getMobileRedisPrefix()+ loginVO.getToken());
        this.redisTemplate.delete(redisKey);
    }

    /**
     * 验证后台令牌的有效性
     * @param jwtToken
     * @return
     */
    public MobileLoginVO  verifyMobileToken(String jwtToken){
        String jwt=parseToken(jwtToken);
        //解析jwt
        if( JWTUtil.verify(jwt, this.tokenProperties.getSign().getBytes())){
            final JWT jwtObject= JWTUtil.parseToken(jwt);
            String uuid=jwtObject.getPayload("uuid").toString();
            //构造一个redisKey
            String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getMobileRedisPrefix()+uuid);
            Object redisValue=this.redisTemplate.opsForValue().get(redisKey);
            if(redisValue!=null){
                return (MobileLoginVO) redisValue;
            }
        }
        return null;
    }

    /**
     * 向redis中写入数据(刷新操作)
     * @param loginVO
     */
    public void refrshToken(MobileLoginVO loginVO){

        //判断，令牌是否快要过期了    未来时间毫秒 -  当前时间毫秒 <= 还有20分钟 毫秒
        long future=loginVO.getExpiredTime().getTime();
        long now=System.currentTimeMillis();

        if(future - now <= this.tokenProperties.getRefreshToken()){
            loginVO.setExpiredTime( DateUtil.offsetMinute(new Date(), this.tokenProperties.getExpiredMinutes()));
            //存储到redis中
            String redisKey= RedisConstant.getRedisKey(this.tokenProperties.getMobileRedisPrefix()+ loginVO.getToken());
            this.redisTemplate.opsForValue().set(redisKey, loginVO, this.tokenProperties.getExpiredMinutes(),TimeUnit.MINUTES);
        }
    }
}
