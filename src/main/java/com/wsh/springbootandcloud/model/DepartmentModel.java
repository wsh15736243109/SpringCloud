package com.wsh.springbootandcloud.model;

/**
 * Created by Administrator on 2018/6/1.
 */
public class DepartmentModel {

    private int id;//自增id
    private String department_name;//部门名字
    private String executive_director;//部门主管名字
    private String create_time;//创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getExecutive_director() {
        return executive_director;
    }

    public void setExecutive_director(String executive_director) {
        this.executive_director = executive_director;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
