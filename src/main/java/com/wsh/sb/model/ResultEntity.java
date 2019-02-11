package com.wsh.sb.model;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 8:34
 * @Description:
 */
public class ResultEntity<T> {

    /**
     * 返回的错误码
     */
    private int code=0;

    /**
     * 错误信息
     */
    private String msg="操作成功";

    /**
     * 返回的具体内容数据类型
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
