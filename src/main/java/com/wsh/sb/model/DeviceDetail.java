package com.wsh.sb.model;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 9:06
 * @Description: 设备详情
 */
public class DeviceDetail {
    //id，设备did,设备密码，设备昵称，设备类型，归属用户id，上次访问时间，上次访问ip，设备型号，设备产地
    private Integer id;
    private String did;
    private String pwd;
    private String device_nickname;
    private String device_type;
    private Integer user_id;
    private long last_visit;
    private String last_ip;
    private String device_model;//设备型号
    private String device_origin_place;//产地

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDevice_nickname() {
        return device_nickname;
    }

    public void setDevice_nickname(String device_nickname) {
        this.device_nickname = device_nickname;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public long getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(long last_visit) {
        this.last_visit = last_visit;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getDevice_origin_place() {
        return device_origin_place;
    }

    public void setDevice_origin_place(String device_origin_place) {
        this.device_origin_place = device_origin_place;
    }
}
