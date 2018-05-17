package com.wsh.springbootandcloud.controller;

import com.wsh.springbootandcloud.dao.PersonMapper;
import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.model.SecurityCodeModel;
import com.wsh.springbootandcloud.util.ResultUtil;
import com.wsh.springbootandcloud.util.SecurityCodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/17 9:16
 * @Description:
 */
@Controller
public class SecurityCodeController extends BaseController {
    @Autowired
    PersonMapper personMapper;

    @RequestMapping("/security_code_send")
    @ResponseBody
    public ResultEntity sendCode(HttpServletRequest httpServletRequest, ResultEntity resultEntity) {
        if (resultEntity.getCode() != 0) {
            return resultEntity;
        }
        String accepter = httpServletRequest.getParameter("phone");//接收者
        String codeType = httpServletRequest.getParameter("type");//验证码类型
        if (accepter == null || accepter.isEmpty()) {
            return fail(-1, "phone parameter is invalid");
        }
        if (codeType == null || codeType.isEmpty()) {
            return fail(-1, "type parameter is invalid");
        }
        if (!codeType.equals("1")||!codeType.equals("2")) {
            return fail(-1,"不支持的验证码类型");
        }
        String code = SecurityCodeHelper.getSecurityCode(6);
        SecurityCodeModel model = new SecurityCodeModel();
        model.setAccepter(accepter);
        model.setCode_value(code);
        model.setType(Integer.parseInt(codeType));
        model.setSend_time(System.currentTimeMillis());
        model.setCode_status(0);
        //将验证码插入数据库
        int re = personMapper.securityCodeAdd(model);
        if (re > 0) {
            return success("验证码发送成功", code);
        } else {
            return fail(-2, "数据库插入失败");
        }
    }
}
