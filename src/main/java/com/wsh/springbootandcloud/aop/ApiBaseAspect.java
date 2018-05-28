package com.wsh.springbootandcloud.aop;

import com.wsh.springbootandcloud.exception.InvalidArgumentException;
import com.wsh.springbootandcloud.model.ResultEntity;
import com.wsh.springbootandcloud.util.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Create by Mr.w
 * @Date:2018/5/16 14:22
 * @Description: 拦截请求参数，处理返回参数
 */
@Aspect
@Component
@Order(-5)
public class ApiBaseAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义一个切入点.
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包* 任意方法
     * ~ .. 匹配任意数量的参数.
     */

//    @Pointcut("execution(public * com.wsh.springbootandcloud.controller.*.*(..))")
//    public void webLog() {
//    }
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws InvalidArgumentException {
//        // 接收到请求，记录请求内容
////        logger.info("WebLogAspect.doBefore()");
////        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
////        HttpServletRequest request = attributes.getRequest();
////        // 记录下请求内容
////        logger.info("URL : " + request.getRequestURL().toString());
////        logger.info("HTTP_METHOD : " + request.getMethod());
////        logger.info("IP : " + request.getRemoteAddr());
////        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
////        //获取所有参数：
////        Enumeration<String> enu = request.getParameterNames();
////        Map<String, Object> paramsMap = new HashMap<>();
////        while (enu.hasMoreElements()) {
////            String paraName = enu.nextElement();
////            paramsMap.put(paraName, request.getParameter(paraName));
////            System.out.println(paraName + ": " + request.getParameter(paraName));
////        }
////        if (!paramsMap.containsKey("time")) {
////            //获取目标方法的参数信息
////            Object[] obj = joinPoint.getArgs();
////            for (Object argItem : obj) {
////                System.out.println("---->now-->argItem:" + argItem);
//////                if (argItem instanceof ResultEntity) {
//////                    ResultEntity paramVO = (ResultEntity) argItem;
//////                    paramVO.setMsg("缺少time参数");
//////                    paramVO.setCode(-1);
//////                }
////                System.out.println("---->after-->argItem:" + argItem);
////            }
////        } else {
////
////        }
//    }
//
//
//    @AfterReturning(value = "execution(* com.wsh.springbootandcloud.controller..*.*(..))", returning = "keys")
//    public void doAfterReturning(JoinPoint joinPoint, Object keys) {
//
////        // 处理完请求，返回内容
////        logger.info("WebLogAspect.doAfterReturning()" + keys.toString());
//
//    }
}
