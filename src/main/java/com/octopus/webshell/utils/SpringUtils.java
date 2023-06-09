/*
 * Copyright © 2020-present octopus-webshell. All Rights Reserved.
 */

package com.octopus.webshell.utils;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * spring上下文工具类
 *
 * @author raymanlei
 * Date 2020/07/03 15:36
 * @title SpringUtils
 */
@Slf4j
@Component
public final class SpringUtils implements ApplicationContextAware {
    /**
     * spring上下文
     */
    private static ApplicationContext context;

    /**
     * @param applicationContext 上下文
     *                           实现ApplicationContextAware接口的context注入函数, 将其存入静态变量
     * @author raymanlei
     * @date 2020/9/2 22:36
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        log.info("初始化上下文：{}", applicationContext);
        SpringUtils.context = applicationContext;
    }

    /**
     * 获取ApplicationContext.
     *
     * @return ApplicationContext
     * @author raymanlei
     * @date 2020/9/2 22:41
     */
    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 从ApplicationContext中取得Bean
     *
     * @param clazz bean
     * @return 对象
     * @author raymanlei
     * @date 2020/9/2 22:40
     */
    public static <T> T getBean(Class<T> clazz) {
        return getContext().getBean(clazz);
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取ServletRequestAttributes
     *
     * @return ServletRequestAttributes
     * @author raymanlei
     * @date 2020/9/6 12:07
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 私有构造器
     *
     * @author raymanlei
     * @date 2020/08/29 14:18
     */
    private SpringUtils() {
    }
}
