package com.wsh.springbootandcloud.util;

import org.apache.catalina.util.ParameterMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/24 13:57
 * @Description:
 */
public class ParameterRequestWrapper extends HttpServletRequestWrapper {

    private ParameterMap<String, String[]> params;

    public ParameterRequestWrapper(HttpServletRequest request) {
        super(request);
        params = (ParameterMap) request.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        // TODO Auto-generated method stub
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    // 就是该方法
    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        // TODO Auto-generated method stub
        return params;
    }

    public void setParams(ParameterMap<String, String[]> params) {
        this.params = params;
    }

    public void addParameter(String name, Object value) {// 增加参数
        if (value != null) {
            params.setLocked(false);
            if (value instanceof String[]) {
                params.put(name, (String[]) value);
            } else if (value instanceof String) {
                params.put(name, new String[]{(String) value});
            } else {
                params.put(name, new String[]{String.valueOf(value)});
            }
            params.setLocked(true);
        }
    }

}
