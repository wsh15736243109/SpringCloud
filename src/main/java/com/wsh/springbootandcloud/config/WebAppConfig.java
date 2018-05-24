package com.wsh.springbootandcloud.config;

import com.wsh.springbootandcloud.interceptor.HeaderParamsCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/24 10:19
 * @Description:
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport {

    @Autowired
    private HeaderParamsCheckInterceptor headerParamsCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        //请求头参数校验
        registry.addInterceptor(headerParamsCheckInterceptor).addPathPatterns(apiUri);
        //登录拦截(这个上一篇文章讲过了，这里说明下两个拦截器前后调用顺序就是本配置类代码的配置顺序)
//        registry.addInterceptor(loginedAuthInterceptor).addPathPatterns(apiUri);
    }
}
