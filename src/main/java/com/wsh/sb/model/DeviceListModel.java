package com.wsh.sb.model;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 9:03
 * @Description:设备列表
 */
public class DeviceListModel {
    //id，设备did,设备密码，设备昵称，设备类型，归属用户id
    private Integer id;
    private String did;
    private String pwd;
    private String device_nickname;
    private String device_type;
    private Integer user_id;

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
}
