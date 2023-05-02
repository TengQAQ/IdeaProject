package com.hxzy.controller.back;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/6-10:39
 * @description TODO
 */

import com.hxzy.common.constants.RedisConstant;
import com.hxzy.common.dto.back.LoginDto;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.common.util.TokenUtil;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.vo.Result;
import com.hxzy.entity.Emp;
import com.hxzy.service.EmpService;
import com.hxzy.vo.back.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author wy
 * @Description 后台登录控制器
 * @Date 2023/4/4 15:56
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api")
@Api(tags = "管理员（emp）登录模块")
@Log4j2
public class LoginController {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmpService employeeService;

    /**
     * 令牌管理工具类
     */
    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 登录  前端axios   axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
     * 1、除了get请求以外，其它的请求默认(put,post,delete)都是以 content-type="application/json"格式提交
     * 前端  application/json 提交，后台必须用 inputStream流来获取数据，不允许使用request.getParameter("键")来获取数据
     * springmvc框架帮我实现 流转换成json对象代码  @RequestBody
     *
     * 2、前端请求  content-type="application/x-www-form-urlencoded"，标准的form表单提交，  jquery.js
     * 只能使用request.getParameter("键") 取值
     * @param loginDTO
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody @Valid LoginDto loginDTO){
//        log.info("输出",loginDTO);

        //1、redis中验证，验证码是否过期
        String redisKey= RedisConstant.getRedisKey(RedisConstant.CAPTCHA_KEY,loginDTO.getUuid());
        Object redisValue=this.redisTemplate.opsForValue().get(redisKey);
        if(redisValue==null){
            return Result.build(AckCode.SMS_CODE_OVERTIME);
        }
        //2、验证验证码是否正确
        if(!redisValue.toString().equalsIgnoreCase(loginDTO.getCode())){
            return Result.build(AckCode.SMS_CODE_WRONG);
        }
        //3、删除redis的验证码
        this.redisTemplate.delete(redisKey);

        //4、查询数据库，根据用户名查询对象
        Emp employee=this.employeeService.login(loginDTO);

        //5、自定义对象，换取令牌(uuid)-->jwt
        String jwtToken=tokenUtil.createJwtToken(employee);
        return Result.okHasData(jwtToken);
    }

    /**
     * 获取当前用户信息
     * @return
     */
    @ApiOperation(value = "获取当前用户信息")
    @GetMapping(value = "/info")
    public Result<AdminLoginVO> userInfo(){
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();
        return Result.okHasData(adminLoginVO);
    }

    /**
     * 退出登录
     * @return
     */
    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/logout")
    public Result logout(){
        this.tokenUtil.backLogout();
        return Result.ok();
    }

}
