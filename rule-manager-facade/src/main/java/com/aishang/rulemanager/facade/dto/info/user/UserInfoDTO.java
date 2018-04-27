package com.aishang.rulemanager.facade.dto.info.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 18-3-2.
 */
public class UserInfoDTO {

    @ApiModelProperty(value = "工号")
    private String username;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "最后一次登录时间")
    private Long lastLogin;
    @ApiModelProperty(value = "最后一次身份认证时间")
    private Long lastAuth;
    @ApiModelProperty(value = "创建时间")
    private Long createdAt;
    @ApiModelProperty(value = "用户状态")
    private Boolean enabled;

    public UserInfoDTO() {
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", lastLogin=" + lastLogin +
                ", lastAuth=" + lastAuth +
                ", createdAt=" + createdAt +
                ", enabled=" + enabled +
                '}';
    }
}
