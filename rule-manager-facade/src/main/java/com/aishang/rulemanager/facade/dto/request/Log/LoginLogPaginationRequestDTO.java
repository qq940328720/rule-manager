package com.aishang.rulemanager.facade.dto.request.Log;

import com.aishang.rulemanager.common.enums.LoginTypeEnum;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import io.swagger.annotations.ApiModelProperty;

/**
 * lt
 */
public class LoginLogPaginationRequestDTO extends BaseRequestParameters {
    @ApiModelProperty(value = "工号")
    private String userName;
    @ApiModelProperty(value = "用户姓名")
    private String realName;
    @ApiModelProperty(value = "登录类型")
    private LoginTypeEnum logenum;
    @ApiModelProperty(value = "起始时间")
    private Long start;
    @ApiModelProperty(value = "结束时间")
    private Long end;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LoginLogPaginationRequestDTO that = (LoginLogPaginationRequestDTO) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (logenum != that.logenum) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        return end != null ? end.equals(that.end) : that.end == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (logenum != null ? logenum.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginLogPaginationRequestDTO{" +
                "userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", logenum=" + logenum +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public LoginTypeEnum getLogenum() {
        return logenum;
    }

    public void setLogenum(LoginTypeEnum logenum) {
        this.logenum = logenum;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
