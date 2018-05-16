package com.wsh.springbootandcloud.exception;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 15:17
 * @Description:
 */
public class InvalidArgumentException extends Exception {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    public InvalidArgumentException(String message){
        super(message);
        this.setCode("-1");
    }

    public InvalidArgumentException(String message, String code){
        super(message);
        this.setCode(code);
    }
}
