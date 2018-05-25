package com.wsh.springbootandcloud.interceptor;

import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.util.Constant;
import com.wsh.springbootandcloud.util.ParameterRequestWrapper;
import com.wsh.springbootandcloud.util.RSAUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.security.PublicKey;

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

            String filed = "app_type";
            ParameterRequestWrapper newRequest = new ParameterRequestWrapper(request);
            String encryptVal = request.getParameter(filed);
            newRequest.addParameter(filed, "改过后的appType");

//            request.getRequestURI().
            if (request.getParameter("data") == null) {
                throw new InvalidArgumentException(-999, "请传入data参数");
            }
            String data = request.getParameter("data").replaceAll(" ", "+");
            System.out.println("原有参数：" + data);
            PublicKey publicKey = RSAUtil.loadPublicKey(Constant.PUBLIC_KEY);
            String dataDecode = new String(RSAUtil.decrypt(publicKey, RSAUtil.base64Decode(data)), UTF8);
            System.out.println("现有解密参数：" + getJsonObject(dataDecode));
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

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        request.
        // nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // nothing to do
    }

}
