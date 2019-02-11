package com.wsh.sb.exception;

import com.wsh.sb.model.ResultEntity;
import com.wsh.sb.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/24 9:52
 * @Description: 统一捕获全局异常信息, 并按统一格式输出
 *               {
 *                  "code":-1,
 *                  "msg":"错误信息",
 *                  "data":null
 *               }
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultEntity defaultExceptionHandler(Exception e) {
        if (e instanceof InvalidArgumentException) {
            return ResultUtil.failR(((InvalidArgumentException) e).getCode(), e.getMessage());
        } else {
            return ResultUtil.failR(-1, e.getMessage());
        }
    }
}
