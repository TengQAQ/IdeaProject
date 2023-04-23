package com.hxzy.common.exception;

import com.hxzy.common.eunms.AckCode;
import com.hxzy.vo.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-23:04
 * @description TODO
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     * @param e
     */
    @ExceptionHandler(WaiMaiException.WaimaiException.class)
    public Result serverException(WaiMaiException.WaimaiException e){
        //记录到日志中，交给程序员修改
        log.error( e);
        //把内容给用户
        return  Result.build(e.getAckCode());
    }

    @ExceptionHandler(BindException.class)
    public Result bindException(BindException e){
        log.error(e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        Result result = Result.build(AckCode.USER_PARAM_IS_NOT_NULL);
        result.setMsg(message);
        return result;
    }

}
