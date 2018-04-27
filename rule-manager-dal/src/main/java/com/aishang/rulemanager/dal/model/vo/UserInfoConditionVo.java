package com.aishang.rulemanager.dal.model.vo;

/**
 * Created by ylj on 18-3-6.
 */
public class UserInfoConditionVo {
    private String username;
    private String realName;
    private String roleName;
    private Long startCreatedAt;
    private Long endCreatedAt;
    private Integer limit;
    private Integer offset;

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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
