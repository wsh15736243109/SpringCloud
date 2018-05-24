package com.wsh.springbootandcloud.controller;

import com.wsh.springbootandcloud.exception.InvalidArgumentException;
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

    /**
     * 参数非空验证
     *
     * @param args
     * @param type
     * @throws Exception
     */
    public void isParameterNull(Object args, String type) throws Exception {
        if (args == null || "".equals(args)) {
            throw new InvalidArgumentException(type);
        }
    }

    public void isExitModel(Object object, String type) throws Exception {
        if (object == null || "".equals(object)) {
            throw new InvalidArgumentException(type);
        }
    }

    public void isEqual(Object arg1, Object arg2, String msg) throws Exception {
        isParameterNull(arg1, "参数为空");
        isParameterNull(arg2, "参数为空");
        if (!arg1.equals(arg2)) {
            throw new InvalidArgumentException(msg);
        }
    }
}
