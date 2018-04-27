package com.aishang.rulemanager.adapter.event;

import com.aishang.rulemanager.common.IpUtil;
import com.aishang.rulemanager.common.enums.LoginResultEnum;
import com.aishang.rulemanager.common.enums.LoginTypeEnum;
import com.aishang.rulemanager.facade.dto.request.Log.LoginLogRequestDTO;
import com.aishang.rulemanager.facade.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginListener {
    @Autowired
    private ILoginLogService iLoginLogService;

    @EventListener(LoginEvent.class)
    @Async
    public void onApplicationEvent(LoginEvent loginEvent) {
        LoginLogRequestDTO loginLog = new LoginLogRequestDTO();
        String id = IpUtil.getIpAddress(loginEvent.getHttpServletRequest());
        loginLog.setIpaddr(id);//登录IP
        loginLog.setUsername(loginEvent.getName());//登录人账号
        loginLog.setRealName("");//登录人真实姓名
        loginLog.setLoginAt(System.currentTimeMillis());//登录时间
        LoginTypeEnum event = (LoginTypeEnum) loginEvent.getSource();
        loginLog.setType(event.getCode());
        loginLog.setResult(loginEvent.getResult().getCode());
        iLoginLogService.loginInsert(loginLog);
    }

    /**
     * 认证成功
     *
     * @param authenticationSuccessEvent
     */
    @EventListener(AuthenticationSuccessEvent.class)
    @Async
    public void onAuthenticationSuccessEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        LoginLogRequestDTO loginLog = new LoginLogRequestDTO();
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authenticationSuccessEvent.getAuthentication().getDetails();
        loginLog.setIpaddr(webAuthenticationDetails.getRemoteAddress());//登录IP
        UserDetails UserDetails = (org.springframework.security.core.userdetails.UserDetails) authenticationSuccessEvent.getAuthentication().getPrincipal();
        loginLog.setUsername(UserDetails.getUsername());//登录人账号
        loginLog.setRealName("");//登录人真实姓名
        loginLog.setLoginAt(System.currentTimeMillis());//登录时间
        loginLog.setType(LoginTypeEnum.SYSTEM.getCode());
        loginLog.setResult(LoginResultEnum.SUCCESS.getCode());
        iLoginLogService.loginInsert(loginLog);
    }

    /**
     * 认证失败
     *
     * @param authenticationFailureBadCredentialsEvent
     */
    @EventListener(AuthenticationFailureBadCredentialsEvent.class)
    @Async
    public void onAuthenticationFailureBadCredentialsEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        LoginLogRequestDTO loginLog = new LoginLogRequestDTO();
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authenticationFailureBadCredentialsEvent.getAuthentication().getDetails();
        loginLog.setIpaddr(webAuthenticationDetails.getRemoteAddress());//登录IP
        String name = (String) authenticationFailureBadCredentialsEvent.getAuthentication().getPrincipal();
        loginLog.setUsername(name);//登录人账号
        loginLog.setRealName("");//登录人真实姓名
        loginLog.setLoginAt(System.currentTimeMillis());//登录时间
        loginLog.setType(LoginTypeEnum.SYSTEM.getCode());
        loginLog.setResult(LoginResultEnum.EXECUTED.getCode());
        iLoginLogService.loginInsert(loginLog);
    }


}
