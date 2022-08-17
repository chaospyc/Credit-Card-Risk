package com.chaossnow.ms.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 从Spring中获取上下文的工具类
 * @author chaos
 * @ClassName SpringContextUtils
 * @date 2022年08月05日 21:03
 * @Version 1.0
 */

@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.context =context;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
