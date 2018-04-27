package com.aishang.rulemanager.facade.dto.info.Log;

import com.aishang.rulemanager.common.enums.LoginResultEnum;
import com.aishang.rulemanager.common.enums.LoginTypeEnum;

/**
 * lt
 */
public class LoginLogInfoDTO {

    private Integer id;


    private String username;


    private String realName;


    private LoginTypeEnum type;


    private Long loginAt;


    private String ipaddr;


    private LoginResultEnum result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public LoginTypeEnum getType() {
        return type;
    }

    public void setType(LoginTypeEnum type) {
        this.type = type;
    }

    public Long getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Long loginAt) {
        this.loginAt = loginAt;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public LoginResultEnum getResult() {
        return result;
    }

    public void setResult(LoginResultEnum result) {
        this.result = result;
    }
}
