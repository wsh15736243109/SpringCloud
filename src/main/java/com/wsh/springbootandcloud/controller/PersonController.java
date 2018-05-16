package com.wsh.springbootandcloud.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsh.springbootandcloud.dao.PersonMapper;
import com.wsh.springbootandcloud.model.PersonModel;
import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.util.ResultUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 8:32
 * @Description: 约定错误返回格式：
 * {
 * "code": 1,
 * "msg": "提示",
 * "data": null
 * }
 */
@Controller
public class PersonController extends BaseController {

    @Autowired
    PersonMapper personMapper;

    /**
     * 用户注册
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/user_register")
    @ResponseBody
    public ResultEntity<PersonModel> register(HttpServletRequest httpServletRequest) {
        String phone = httpServletRequest.getParameter("phone");
        String pwd = httpServletRequest.getParameter("pwd");
        if (phone == null || "".equals(phone)) {
            return ResultUtil.fail(-1, "invalid phone parameter");
        }
        if (pwd == null || "".equals(pwd)) {
            return ResultUtil.fail(-1, "invalid pwd parameter");
        }
        //是否已经存在
        if (personMapper.getCountByPhone(phone) > 0) {
            return ResultUtil.fail(-1, "该账号已注册");
        }
        //数据库插入
        PersonModel model = new PersonModel();
        model.setPhone(phone);
        model.setPwd(pwd);
        model.setNickname("user_" + phone);
        model.setRegister_time(System.currentTimeMillis());
        try {
            int re = personMapper.register_user(model);
            if (re > 0) {
                return ResultUtil.success("操作成功", "注册成功");
            } else {
                return ResultUtil.success("操作成功", "插入数据库失败");
            }
        } catch (Exception e) {
            return ResultUtil.fail(-1, e.getMessage());
        }

    }

    @RequestMapping("/user_login")
    @ResponseBody
    public ResultEntity userLogin(HttpServletRequest httpServletRequest, ResultEntity resultEntity) {
        if (resultEntity.getCode() != 0) {
            return resultEntity;
        }
        String phone = httpServletRequest.getParameter("phone");
        String pwd = httpServletRequest.getParameter("pwd");
        if (phone == null || "".equals(phone)) {
            return ResultUtil.fail(-1, "invalid phone parameter");
        }
        if (pwd == null || "".equals(pwd)) {
            return ResultUtil.fail(-1, "invalid pwd parameter");
        }

        PersonModel model = personMapper.findByPhone(phone);
        if (model == null) {
            return ResultUtil.fail(-1, "未找到该账户");
        } else {
            return ResultUtil.success("登录成功", model);
        }
    }

    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public String getPersonAll(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("list", "zhangsan");
        return "PersonHtml";
    }

    public void deletePersonById(String id) {

    }

    public void addPerson(PersonModel personModel) {

    }

    public void updatePerson(PersonModel personModel) {

    }

    public void getPersonById(String id) {

    }
}
