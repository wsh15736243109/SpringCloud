package com.wsh.springbootandcloud.interceptor;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.internal.LinkedTreeMap;
import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.util.Constant;
import com.wsh.springbootandcloud.util.ParameterRequestWrapper;
import com.wsh.springbootandcloud.util.RSAUtil;
import org.apache.catalina.util.ParameterMap;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.util.Iterator;

import static com.wsh.springbootandcloud.util.JSONUtil.getJsonObject;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/24 10:23
 * @Description: 参数拦截器，本类将对前端入参进行解密，将解密后的paramMap传递到Controller
 */
@Component
public class HeaderParamsCheckInterceptor implements HandlerInterceptor {
    public static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
//            ParameterRequestWrapper newRequest = new ParameterRequestWrapper(request);
//            if (request.getParameter("data") == null) {
//                throw new InvalidArgumentException(-999, "请传入data参数");
//            }
//            String data = request.getParameter("data").replaceAll(" ", "+");
//            System.out.println("原有参数==" + data);
//            PublicKey publicKey = RSAUtil.loadPublicKey(Constant.PUBLIC_KEY);
//            String dataDecode = new String(RSAUtil.decrypt(publicKey, RSAUtil.base64Decode(data)), UTF8);
//            JSONObject jsonObject = getJsonObject(dataDecode);
//            System.out.println("现有参数==" + jsonObject);
//            if (!jsonObject.has("app_type")) {
//                throw new InvalidArgumentException(-999, "请传入app_type参数");
//            }
//            Iterator<String> mIterator = jsonObject.keys();
//            while (mIterator.hasNext()) {
//                String key = mIterator.next() + "";
//                String value = jsonObject.getString(key);
//                newRequest.addParameter(key, value);
//            }
//            newRequest.addParameter("data","data 改过后");
//            String callSource = request.getHeader(HeaderConstants.CALL_SOURCE);
//            String apiVersion = request.getHeader(HeaderConstants.API_VERSION);
//            String appVersion = request.getHeader(HeaderConstants.APP_VERSION);
//
//            if (StringUtil.isAnyBlank(callSource, apiVersion)) {
//                throw new BusinessException(ResultCode.PARAM_NOT_COMPLETE);
//            }
//
//            try {
//                Double.valueOf(apiVersion);
//            } catch (NumberFormatException e) {
//                throw new BusinessException(ResultCode.PARAM_IS_INVALID);
//            }
//
//            if ((CallSource.ANDROID.name().equals(callSource) || CallSource.IOS.name().equals(callSource)) && StringUtil.isEmpty(appVersion)) {
//                throw new BusinessException(ResultCode.PARAM_NOT_COMPLETE);
//            }
//
//            if (!CallSource.isValid(callSource)) {
//                throw new BusinessException(ResultCode.PARAM_IS_INVALID);
//            }
//            throw new InvalidArgumentException(-999,"参数有误");
        }

        return true;
    }

    /*******
     * 动态解析key-value
     *
     *  LinkedTreeMap<String, String> linkedTreeMap = (LinkedTreeMap<String, String>) configBean.getPRODUCT_CENTER_CATE_ATTR();
     Iterator it = linkedTreeMap.keySet().iterator();
     while (it.hasNext()) {
     String key = it.next() + "";
     String value = linkedTreeMap.get(key);
     mTabLayout.addTab(mTabLayout.newTab().setText(value).setTag(key));
     mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override public void onTabSelected(TabLayout.Tab tab) {
    attr=tab.getTag().toString();
    pullDown();
    }

    @Override public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override public void onTabReselected(TabLayout.Tab tab) {

    }
    });
     }
     */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
       System.out.println(request);
        // nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        // nothing to do
        System.out.println(request);
    }

}
