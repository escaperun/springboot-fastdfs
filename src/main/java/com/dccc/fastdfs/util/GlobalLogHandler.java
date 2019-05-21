package com.dccc.fastdfs.util;

import org.apache.juli.ClassLoaderLogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * @author luyang
 * @ClassName GlobalLogHandler
 * @description 〈功能详细描述〉
 * @time 2019/5/2016:35
 * @modificationHistory <记录修改历史记录 who where what>
 */
@Aspect
public class GlobalLogHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalLogHandler.class);
    @Pointcut("execution(* com.dccc..*.*(..))")
    public void globalLog(){};

    @Before("globalLog()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("REQUEST URL::" + request.getRequestURL());
        logger.info("METHOE::" + request.getMethod());
        logger.info("REQUEST ADD::" + request.getRemoteAddr());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String param = parameterNames.nextElement();
            logger.info("paramter:{},value:{}" + request.getParameter(param));
        }
    }
    @AfterReturning(returning = "ref", pointcut = "globalLog()")
    public void doAfter(Object ref){
        logger.info("RESPONSE::" + ref);
    }


}
