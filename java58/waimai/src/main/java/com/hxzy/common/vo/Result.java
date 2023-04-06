package com.hxzy.common.vo;

import com.hxzy.common.eunms.AckCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-15:38
 * @description TODO
 */
@ToString
@Getter
@Setter
public class Result<T> {
    private final long timestamps = System.currentTimeMillis();
    private int code;
    private T data;
    private String msg;

    public synchronized static <T> Result<T> build(AckCode statusEnum) {
        return build(statusEnum, null);
    }

    public synchronized static <T> Result<T> build(AckCode ackCode, T data) {
        Result<T> res = new Result<>();
        res.setCode(ackCode.code);
        res.setMsg(ackCode.msg);
        res.setData(data);
        return res;
    }

    public synchronized static <T> Result<T> build(AckCode ackCode, T data, String msg) {
        Result<T> res = new Result<>();
        res.setCode(ackCode.code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public synchronized static <T> Result<T> ok() {
        return build(AckCode.SUCCESS, null);
    }

    public synchronized static <T> Result<T> okHasData(T data) {
        return build(AckCode.SUCCESS, data);
    }

}
