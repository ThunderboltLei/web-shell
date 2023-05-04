/*
 * Copyright © 2020-present octopus-webshell. All Rights Reserved.
 */

package com.octopus.webshell.handler;

import com.octopus.webshell.utils.ServerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动成功后执行
 *
 * @author raymanlei
 * @version 1.0
 * @title ApplicationStartup
 * @date 2021/2/23 22:05
 */
@Slf4j
@Component
public class ApplicationStartup implements CommandLineRunner {
    /**
     * 应用的访问端口
     */
    @Value("${server.port}")
    private int port;

    /**
     * 应用的访问路径上下文
     */
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public void run(String... args) {
        log.info("项目启动成功！访问地址：{}", "https://" + ServerUtils.getHostIp() + ":" + port + contextPath);
    }
}
