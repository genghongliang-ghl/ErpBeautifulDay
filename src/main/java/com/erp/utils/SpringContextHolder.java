package com.erp.utils;

import org.springframework.context.ApplicationContext;


/**
 * @author : DongChenchen
 * @date : 2019/9/6 0:12
 */
public class SpringContextHolder {
	private static ApplicationContext applicationContext;

	// 获取上下文
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 设置上下文
	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	// 通过名字获取上下文中的bean
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}

	// 通过类型获取上下文中的bean
	public static <T> T getBean(Class<?> requiredType) {
		return (T) applicationContext.getBean(requiredType);
	}

}
