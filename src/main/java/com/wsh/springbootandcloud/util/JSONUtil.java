package com.wsh.springbootandcloud.util;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/25 16:17
 * @Description:
 */
public class JSONUtil {

    public static JSONPObject getJsonObject(Object object){
       JSONPObject jsonpObject=new JSONPObject("",object) ;
       return jsonpObject;
    }
}
