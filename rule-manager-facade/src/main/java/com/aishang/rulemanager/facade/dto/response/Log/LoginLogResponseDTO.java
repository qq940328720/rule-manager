package com.aishang.rulemanager.facade.dto.response.Log;

import com.aishang.rulemanager.common.enums.LoginTypeEnum;
import com.aishang.rulemanager.facade.dto.response.base.BaseResponseDTO;

/**
 * lt
 */
public class LoginLogResponseDTO extends BaseResponseDTO {
    private Integer id;
    private String username;
    private String realName;
    private LoginTypeEnum type;
    private Long loginAt;
    private String ipaddr;

    @Override
    public String toString() {
        return "LoginLogResponseDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", type=" + type +
                ", loginAt=" + loginAt +
                ", ipaddr='" + ipaddr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginLogResponseDTO that = (LoginLogResponseDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (type != that.type) return false;
        if (loginAt != null ? !loginAt.equals(that.loginAt) : that.loginAt != null) return false;
        return ipaddr != null ? ipaddr.equals(that.ipaddr) : that.ipaddr == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (loginAt != null ? loginAt.hashCode() : 0);
        result = 31 * result + (ipaddr != null ? ipaddr.hashCode() : 0);
        return result;
    }

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
}
