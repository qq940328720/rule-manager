package com.aishang.rulemanager.assembly.config.security.handler;

import com.aishang.rulemanager.common.IpUtil;
import com.aishang.rulemanager.common.enums.LoginResultEnum;
import com.aishang.rulemanager.common.enums.LoginTypeEnum;
import com.aishang.rulemanager.facade.dto.request.Log.LoginLogRequestDTO;
import com.aishang.rulemanager.facade.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * lt
 */
@Component
public class RestAuthenticationLogoutHandler implements LogoutHandler {
    @Autowired
    ILoginLogService loginLogService;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        if (null == authentication) {
            return;
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        LoginLogRequestDTO loginLogRequestDTO = new LoginLogRequestDTO();
        loginLogRequestDTO.setType(LoginTypeEnum.OUT.getCode());//类型
        loginLogRequestDTO.setUsername(userDetails.getUsername());//登录用户名称
        loginLogRequestDTO.setLoginAt(System.currentTimeMillis());//推出时间
        loginLogRequestDTO.setRealName("");
        loginLogRequestDTO.setIpaddr(IpUtil.getIpAddress(httpServletRequest));//ip地址
        loginLogRequestDTO.setResult(LoginResultEnum.SUCCESS.getCode());//推出结果
        loginLogService.loginInsert(loginLogRequestDTO);
    }
}
