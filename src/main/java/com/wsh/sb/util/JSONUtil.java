package com.wsh.sb.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/25 16:17
 * @Description:
 */
public class JSONUtil {


    public static JSONObject getJsonObject(Object object) throws JSONException {
        JSONObject jsonpObject = new JSONObject(object.toString());
        return jsonpObject;
    }
}
