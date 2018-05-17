package com.wsh.springbootandcloud.model;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/17 9:48
 * @Description:
 */
public class SecurityCodeModel {
    private int id;
    private String code_value;
    private String accepter;
    private long send_time;
    private int code_status;//0：初始状态，未验证，1：验证通过，2：超时已失效，3:验证码已使用
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_value() {
        return code_value;
    }

    public void setCode_value(String code_value) {
        this.code_value = code_value;
    }

    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter;
    }

    public long getSend_time() {
        return send_time;
    }

    public void setSend_time(long send_time) {
        this.send_time = send_time;
    }

    public int getCode_status() {
        return code_status;
    }

    public void setCode_status(int code_status) {
        this.code_status = code_status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SecurityCodeModel{" +
                "id=" + id +
                ", code_value='" + code_value + '\'' +
                ", accepter='" + accepter + '\'' +
                ", send_time=" + send_time +
                ", code_status=" + code_status +
                ", type=" + type +
                '}';
    }
}
