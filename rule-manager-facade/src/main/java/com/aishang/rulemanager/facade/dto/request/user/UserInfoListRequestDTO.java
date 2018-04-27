package com.aishang.rulemanager.facade.dto.request.user;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ylj on 18-3-6.
 */
public class UserInfoListRequestDTO extends BaseRequestParameters{

    @ApiModelProperty(value = "工号")
    private String username;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "起始创建时间")
    private Long startCreatedAt;
    @ApiModelProperty(value = "结束创建时间")
    private Long endCreatedAt;

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

    public Long getStartCreatedAt() {
        return startCreatedAt;
    }

    public void setStartCreatedAt(Long startCreatedAt) {
        this.startCreatedAt = startCreatedAt;
    }

    public Long getEndCreatedAt() {
        return endCreatedAt;
    }

    public void setEndCreatedAt(Long endCreatedAt) {
        this.endCreatedAt = endCreatedAt;
    }

    public UserInfoListRequestDTO() {
    }

    @Override
    public String toString() {
        return "UserInfoListRequestDTO{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", startCreatedAt=" + startCreatedAt +
                ", endCreatedAt=" + endCreatedAt +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserInfoListRequestDTO that = (UserInfoListRequestDTO) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (startCreatedAt != null ? !startCreatedAt.equals(that.startCreatedAt) : that.startCreatedAt != null)
            return false;
        return endCreatedAt != null ? endCreatedAt.equals(that.endCreatedAt) : that.endCreatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (startCreatedAt != null ? startCreatedAt.hashCode() : 0);
        result = 31 * result + (endCreatedAt != null ? endCreatedAt.hashCode() : 0);
        return result;
    }
}
