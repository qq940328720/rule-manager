package com.aishang.rulemanager.facade.dto.request.Log;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestDTO;

/**
 * lt
 */
public class LoginLogRequestDTO extends BaseRequestDTO {
    private String username;
    private String realName;
    private Integer type;
    private Long loginAt;
    private String ipaddr;
    private Integer result;

    @Override
    public String toString() {
        return "LoginLogRequestDTO{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", type=" + type +
                ", loginAt=" + loginAt +
                ", ipaddr='" + ipaddr + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginLogRequestDTO that = (LoginLogRequestDTO) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (loginAt != null ? !loginAt.equals(that.loginAt) : that.loginAt != null) return false;
        if (ipaddr != null ? !ipaddr.equals(that.ipaddr) : that.ipaddr != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = username != null ? username.hashCode() : 0;
        result1 = 31 * result1 + (realName != null ? realName.hashCode() : 0);
        result1 = 31 * result1 + (type != null ? type.hashCode() : 0);
        result1 = 31 * result1 + (loginAt != null ? loginAt.hashCode() : 0);
        result1 = 31 * result1 + (ipaddr != null ? ipaddr.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
