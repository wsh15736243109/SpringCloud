package com.wsh.sb.util;

import com.wsh.sb.model.ResultEntity;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 8:37
 * @Description:json数据返回工具类
 */
public class ResultUtil {
    public static ResultEntity successR(String message, Object object) {
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setCode(0);
        resultEntity.setMsg(message);
        resultEntity.setData(object);
        return resultEntity;
    }

    public static ResultEntity failR(Integer code, String msg) {
        ResultEntity result = new ResultEntity();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
