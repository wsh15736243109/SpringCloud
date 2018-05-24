package com.wsh.springbootandcloud.interceptor;

import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.util.ParameterRequestWrapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/24 10:23
 * @Description: 参数拦截器，本类将对前端入参进行解密，将解密后的paramMap传递到Controller
 */
@Component
public class HeaderParamsCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {

            String filed = "app_type";
            ParameterRequestWrapper newRequest = new ParameterRequestWrapper(request);
            String encryptVal = request.getParameter(filed);
            newRequest.addParameter(filed, "改过后的appType");


            if (request.getParameter("data") == null) {
                throw new InvalidArgumentException(-999, "请传入data参数");
            }
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
