package com.aishang.rulemanager.facade.dto.response.user;

import java.util.Objects;

public class UserAuthResponseDTO extends UserBaseResponseDTO {

    private String username;
    private String password;
    private Boolean enabled;
    private String realName;
    private Long lastLogin;
    private Long lastAuth;
    private Long createdAt;
    private Long updatedAt;

    public UserAuthResponseDTO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthResponseDTO that = (UserAuthResponseDTO) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(realName, that.realName) &&
                Objects.equals(lastLogin, that.lastLogin) &&
                Objects.equals(lastAuth, that.lastAuth) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, enabled, realName, lastLogin, lastAuth, createdAt, updatedAt);
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Long getLastAuth() {
        return lastAuth;
    }

    public void setLastAuth(Long lastAuth) {
        this.lastAuth = lastAuth;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserAuthResponseDTO(String username, String password, Boolean enabled, String realName, Long lastLogin, Long lastAuth, Long createdAt, Long updatedAt) {

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.realName = realName;
        this.lastLogin = lastLogin;
        this.lastAuth = lastAuth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
