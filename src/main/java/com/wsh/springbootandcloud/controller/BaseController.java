package com.wsh.springbootandcloud.controller;

import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 13:35
 * @Description: Controller基类
 */
@Controller
public class BaseController {

    public ResultEntity success(String message, Object object) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(0);
        resultEntity.setMsg(message);
        resultEntity.setData(object);
        return resultEntity;
    }

    public ResultEntity fail(Integer code, String msg) {
        ResultEntity result = new ResultEntity();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public void isNull(Object args) {
        if (args == null) {

        }
    }
}
