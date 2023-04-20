package com.hxzy.common.exception;

import com.hxzy.common.enums.AckCode;
import com.hxzy.common.vo.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 解决所有系统中500的错误问题
 * @author 11452
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     * @param e
     */
    @ExceptionHandler(value = WaimaiException.class)
    public R serverException(WaimaiException e){
        //记录到日志中，交给程序员修改
        log.error( e);
        //把内容给用户
        return  R.build( e.getAckCode());
    }


    /**
     * hibernate-validator提交数据验证不通过的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public R bindException(BindException  e){
        log.error(e);
        String error=e.getAllErrors().get(0).getDefaultMessage();

        R r = R.build(AckCode.USER_PARAM_IS_NOT_NULL);
        r.setMsg(error);
        return r;
    }



}
