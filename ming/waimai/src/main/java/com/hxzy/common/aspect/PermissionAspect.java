package com.hxzy.common.aspect;

import com.hxzy.common.eunms.AckCode;
import com.hxzy.common.exception.WaiMaiException;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.vo.back.AdminLoginVO;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/5/2-15:22
 * @description TODO
 */
@Aspect
@Component
public class PermissionAspect {

    /**
     *    定义什么叫管理员才能访问方法，认为，方法上面有 @Admin注解的
     */
    @Pointcut(value = "@annotation(com.hxzy.common.annontation.Admin)")
    private void adminMethod(){
    }

    /**
     *    定义什么叫商家才能访问方法，认为，方法上面有 @Shop注解的
     */
    @Pointcut(value = "@annotation(com.hxzy.common.annontation.Shop)")
    private void shopMethod(){
    }


    /**
     *  增强的代码，代理对象自己事情的（@Before,  @After @AfterReturing @AfterThrowing,  @Around）
     * 只能是管理员才能访问
     */
    @Before(value ="adminMethod()" )
    public void adminCheckPermisson(){
        AdminLoginVO adminLoginVO= WaimaiThreadLocal.adminThreadLocal.get();
        if(adminLoginVO.getAccountType()!=1){
            throw new WaiMaiException.WaimaiException(AckCode.NO_PERMISSION_TO_ACCESS);
        }
    }

    /**
     *  增强的代码，代理对象自己事情的（@Before,  @After @AfterReturing @AfterThrowing,  @Around）
     * 只能是商家才能访问
     */
    @Before(value ="shopMethod()" )
    public void shopCheckPermisson(){
        AdminLoginVO adminLoginVO= WaimaiThreadLocal.adminThreadLocal.get();
        if(adminLoginVO.getAccountType()!=2){
            throw new WaiMaiException.WaimaiException(AckCode.ADMIN_VALUE_NOT_CHANGE);
        }
    }
}
