/*
 * Copyright © 2020-present octopus-webshell. All Rights Reserved.
 */

package com.octopus.webshell.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * web shell数据传输
 * @title WebSSHData
 * @author raymanlei
 * @version 1.0
 * @date 2021/2/23 20:57
 */
@Data
public class WebShellData implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = -2326528171211907216L;
    /** 操作类型 */
    private String operate;
    /** 主机IP */
    private String host;
    /** 端口号 默认22 */
    private Integer port = 22;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 命令 */
    private String command = "";
}
