/*
 * Copyright © 2020-present octopus-webshell. All Rights Reserved.
 */

package com.octopus.webshell.controller;

import com.alibaba.fastjson.JSON;
import com.octopus.webshell.utils.EhCacheUtils;
import com.octopus.webshell.utils.SftpUtils;
import com.octopus.webshell.utils.WebShellUtils;
import com.octopus.webshell.vo.WebShellData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 路由控制类
 *
 * @author raymanlei
 * @version 1.0
 * @title RouterController
 * @date 2021/1/30 23:32
 */
@Slf4j
@Controller
public class RouterController {
    /**
     * index
     *
     * @author raymanlei
     * @date 2021/1/30 23:33
     */
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * sftp
     *
     * @author raymanlei
     * @date 2021/2/26 16:40
     */
    @GetMapping("/sftp")
    public String sftp(String params, Model model) {
        String sessionId = WebShellUtils.getSessionId();
        log.info("sessionId：{}", sessionId);
        WebShellData sshData = JSON.parseObject(params, WebShellData.class);
        // 存放ssh连接信息
        if (sshData != null) {
            EhCacheUtils.put(sessionId, sshData);
        } else {
            sshData = EhCacheUtils.get(sessionId);
        }
        if (sshData != null) {
            SftpUtils sftpUtils = new SftpUtils(sshData);
            boolean login = sftpUtils.login();
            // 登录成功状态
            model.addAttribute("login", login);
            model.addAttribute("host", sshData.getHost());
            sftpUtils.logout();
        }
        return "sftp";
    }
}
