package com.shannonai.springboot.exception;

/**
 * 后端接口返回异常
 * @author crockitwood
 * @date 2021/1/22
 */
public class RspException extends Exception{

    public RspException(String msg) {
        super(msg);
    }

}
