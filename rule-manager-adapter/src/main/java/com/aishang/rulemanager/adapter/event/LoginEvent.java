package com.aishang.rulemanager.adapter.event;

import com.aishang.rulemanager.common.enums.LoginResultEnum;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * 李通
 */
public class LoginEvent extends ApplicationEvent {
    private String name;
    private LoginResultEnum result;
    private HttpServletRequest httpServletRequest;

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 自定义事件
     */
    public LoginEvent(Object source, String name, HttpServletRequest httpServletRequest, LoginResultEnum result) {
        super(source);
        this.name = name;
        this.httpServletRequest = httpServletRequest;
        this.result = result;
    }

    public LoginResultEnum getResult() {
        return result;
    }

    public void setResult(LoginResultEnum result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
