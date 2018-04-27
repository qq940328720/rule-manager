package com.aishang.rulemanager.facade.dto.response.user;

import java.util.Objects;

public class UserRoleResponseDTO extends UserBaseResponseDTO {
    private String roleCode;
    private String userCode;

    @Override
    public String toString() {
        return "UserRoleResponseDTO{" +
                "roleCode='" + roleCode + '\'' +
                ", userCode='" + userCode + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleResponseDTO that = (UserRoleResponseDTO) o;
        return Objects.equals(roleCode, that.roleCode) &&
                Objects.equals(userCode, that.userCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleCode, userCode);
    }

    public String getRoleCode() {

        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public UserRoleResponseDTO() {

    }

    public UserRoleResponseDTO(String roleCode, String userCode) {

        this.roleCode = roleCode;
        this.userCode = userCode;
    }
}
