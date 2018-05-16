package com.wsh.springbootandcloud.model;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 8:34
 * @Description:
 */
public class ResultEntity<T> {

    /**
     * 返回的错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回的具体内容数据类型
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
