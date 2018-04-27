package com.aishang.rulemanager.facade.dto.request.user;

import java.util.Objects;

public class UserAuthRequestDTO extends UserBaseRequestDTO {

    private String username;
    private String password;

    public UserAuthRequestDTO() {
    }

    public UserAuthRequestDTO(String username, String password) {

        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthRequestDTO that = (UserAuthRequestDTO) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "UserAuthRequestDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
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
}
