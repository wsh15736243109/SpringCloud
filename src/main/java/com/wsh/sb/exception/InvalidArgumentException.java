package com.wsh.sb.exception;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 15:17
 * @Description:
 */
public class InvalidArgumentException extends Exception {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    public InvalidArgumentException(String message) {
        super(message);
        this.setCode(-1);
    }

    public InvalidArgumentException(int code, String message) {
        super(message);
        this.setCode(code);
    }
}
