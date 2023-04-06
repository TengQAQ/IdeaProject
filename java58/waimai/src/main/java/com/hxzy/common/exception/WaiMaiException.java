package com.hxzy.common.exception;

import com.hxzy.common.eunms.AckCode;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/5-22:48
 * @description TODO
 */
public class WaiMaiException {

    /**
     * 所有自定义异常
     *
     * @author tonneyyy
     */
    public class WaimaiException extends RuntimeException {

        private AckCode ackCode;

        public AckCode getAckCode() {
            return ackCode;
        }


        public WaimaiException(AckCode ackCode) {
            super(ackCode.getMsg());
            this.ackCode = ackCode;
        }


        public WaimaiException(Throwable cause, AckCode ackCode) {
            super(cause);
            this.ackCode = ackCode;
        }
    }
}
