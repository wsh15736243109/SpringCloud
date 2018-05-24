package com.wsh.springbootandcloud.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsh.springbootandcloud.dao.PersonMapper;
import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.model.PersonModel;
import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.model.SecurityCodeModel;
import com.wsh.springbootandcloud.service.PeronService;
import com.wsh.springbootandcloud.util.CodeType;
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

    @Autowired
    PeronService personService;

    /**
     * 用户注册
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/user_register")
    @ResponseBody
    public ResultEntity<PersonModel> register(HttpServletRequest httpServletRequest) throws Exception {
        String phone = httpServletRequest.getParameter("phone");
        String pwd = httpServletRequest.getParameter("pwd");
        String code = httpServletRequest.getParameter("code");
        isParameterNull(phone, "phone");
        isParameterNull(pwd, "pwd");
        isParameterNull(code, "code");
        //是否已经存在
        isParameterNull(personMapper.findByPhone(phone), "该账号已注册");
        //查询验证码是否有效
        SecurityCodeModel securityCodeModel = personMapper.isValidCode(code, phone, CodeType.CODE_REGISTER);
        isParameterNull(securityCodeModel, "验证码验证失败");
        //查询到了该条验证码信息，是否已经超过有效时间
        if (System.currentTimeMillis() - securityCodeModel.getSend_time() > CodeType.CODE_TIMEOUT) {
            throw new InvalidArgumentException(-1, "该验证码已经失效");
        }
        //数据库插入
        PersonModel model = new PersonModel();
        model.setPhone(phone);
        model.setPwd(pwd);
        model.setNickname("user_" + phone);
        model.setRegister_time(System.currentTimeMillis());
        int re = personMapper.register_user(model);
        if (re > 0) {
            //修改验证码状态 为已使用
            securityCodeModel.setCode_status(3);
            int reCode = personMapper.updateSecurityCode(securityCodeModel);
            if (reCode > 0) {
                return success("操作成功", "注册成功");
            } else {
                return success("验证码状态更新失败", "插入数据库失败");
            }
        } else {
            return success("操作失败", "用户数据库更新失败");
        }

    }

    @RequestMapping(value = "/user_login", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity userLogin(HttpServletRequest httpServletRequest) throws Exception {
        String phone = httpServletRequest.getParameter("phone");
        String pwd = httpServletRequest.getParameter("pwd");
        isParameterNull(phone, "phone");
        isParameterNull(pwd, "pwd");
        PersonModel model = personMapper.findByPhone(phone);
        isExitModel(model, "未找到该账户");
        isEqual(pwd, model.getPwd(), "密码错误");
        return success("登录成功", model);
    }

    @RequestMapping("/user_updatePassword")
    @ResponseBody
    public ResultEntity updatePassword(HttpServletRequest httpServletRequest, ResultEntity resultEntity) {
        if (resultEntity.getCode() != 0) {
            return resultEntity;
        }
        String phone = httpServletRequest.getParameter("phone");
        String pwd = httpServletRequest.getParameter("pwd");
        String code = httpServletRequest.getParameter("code");
        if (phone == null || "".equals(phone)) {
            return fail(-1, "invalid phone parameter");
        }
        if (pwd == null || "".equals(pwd)) {
            return fail(-1, "invalid pwd parameter");
        }
        if (code == null || "".equals(code)) {
            return fail(-1, "invalid code parameter");
        }
        //是否已经存在
        if (personMapper.getCountByPhone(phone) <= 0) {
            return fail(-1, "该账号不存在");
        }

        //查询验证码是否有效
        SecurityCodeModel securityCodeModel = personMapper.isValidCode(code, phone, CodeType.CODE_UPDATE_PASSWORD);
        if (securityCodeModel != null) {
            //是否已经使用过
            if (securityCodeModel.getCode_status() == 3) {
                return fail(-1, "该验证码无效");
            }
            //查询到了该条验证码信息，是否已经超过有效时间
            if (System.currentTimeMillis() - securityCodeModel.getSend_time() > CodeType.CODE_TIMEOUT) {
                return fail(-1, "该验证码已经失效");
            }
        } else {
            return fail(-1, "验证码验证失败");
        }

        //修改密码
        int re = personMapper.updateUserPassword(phone, pwd);
        if (re > 0) {
            //修改验证码状态 为已使用
            securityCodeModel.setCode_status(3);
            int reCode = personMapper.updateSecurityCode(securityCodeModel);
            if (reCode > 0) {
                return success("操作成功", "修改密码成功");
            } else {
                return fail(-1, "验证码状态更新失败");
            }
        } else {
            return fail(-1, "插入数据库失败");
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
