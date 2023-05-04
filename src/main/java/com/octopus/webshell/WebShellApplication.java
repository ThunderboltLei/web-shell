/*
 * Copyright © 2020-present octopus-webshell. All Rights Reserved.
 */

package com.octopus.webshell;

import com.octopus.webshell.utils.ThreadPoolUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 程序入口
 * @title WebShellApplication
 * @author raymanlei
 * @version 1.0
 * @date 2021/1/30 23:00
 */
@SpringBootApplication
@EnableCaching
public class WebShellApplication {
	public static void main(String[] args) {
		// log4j2全局异步日志配置 http://logging.apache.org/log4j/2.x/manual/async.html#AllAsync
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		SpringApplication.run(WebShellApplication.class, args);

		// 停止应用时，关闭线程池钩子，或者使用 @PreDestroy 注解执行一系列操作
		Runtime.getRuntime().addShutdownHook(new Thread(ThreadPoolUtils::shutdown, "ShutdownThreadPoolHook"));
	}
}
