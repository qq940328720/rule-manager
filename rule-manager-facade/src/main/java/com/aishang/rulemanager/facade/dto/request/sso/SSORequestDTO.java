package com.aishang.rulemanager.facade.dto.request.sso;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestDTO;

import java.util.Objects;

public class SSORequestDTO extends BaseRequestDTO {

    private String username;
    private String password;
    private String redirect;

    public SSORequestDTO() {
    }

    public SSORequestDTO(String username, String password, String redirect) {
        this.username = username;
        this.password = password;
        this.redirect = redirect;
    }

    @Override
    public String toString() {
        return "SSORequestDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", redirect='" + redirect + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SSORequestDTO that = (SSORequestDTO) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(redirect, that.redirect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, redirect);
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

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
