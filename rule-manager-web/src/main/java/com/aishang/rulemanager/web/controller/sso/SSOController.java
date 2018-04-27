package com.aishang.rulemanager.web.controller.sso;

import com.aishang.rulemanager.adapter.event.LoginEvent;
import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.common.enums.LoginResultEnum;
import com.aishang.rulemanager.common.enums.LoginTypeEnum;
import com.aishang.rulemanager.facade.dto.request.sso.SSORequestDTO;
import com.aishang.rulemanager.facade.dto.request.user.UserAuthRequestDTO;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.rulemanager.facade.dto.response.user.UserAuthResponseDTO;
import com.aishang.rulemanager.facade.service.IUserService;
import com.aishang.rulemanager.sso.JwtTokenUtil;
import com.aishang.rulemanager.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("auth")
public class SSOController extends BaseController {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${app.domain}")
    String appDomain;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @GetMapping
    public String toLoginPage() throws Exception {
        return "sso/login";
    }

    @PostMapping
    public @ResponseBody
    ResponseDTOWrapper doLoginAndRedirect(HttpServletResponse response, SSORequestDTO ssoRequestDTO) throws Exception {
        UserAuthResponseDTO userDetails = userService.auth(new UserAuthRequestDTO(ssoRequestDTO.getUsername(), ssoRequestDTO.getPassword()));
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (null == userDetails || !passwordEncoder.matches(ssoRequestDTO.getPassword(), userDetails.getPassword())) {
            LoginEvent loginEvent = new LoginEvent(LoginTypeEnum.API, userDetails.getUsername(), httpServletRequest, LoginResultEnum.EXECUTED);
            applicationEventPublisher.publishEvent(loginEvent);//记录app登录
            return createResponse(ErrorCode.BAD_CREDENTIALS_EXCEPTION);
        }

        if (!userDetails.getEnabled()) {
            LoginEvent loginEvent = new LoginEvent(LoginTypeEnum.API, userDetails.getUsername(), httpServletRequest, LoginResultEnum.EXECUTED);
            applicationEventPublisher.publishEvent(loginEvent);//记录app登录
            return createResponse(ErrorCode.AUTHENTICATION_FAILURE);
        }

        LoginEvent loginEvent = new LoginEvent(LoginTypeEnum.API, userDetails.getUsername(), httpServletRequest, LoginResultEnum.SUCCESS);
        applicationEventPublisher.publishEvent(loginEvent);//记录app登录
        String tokenValue = jwtTokenUtil.generateToken(ssoRequestDTO.getUsername());
        Cookie cookie = new Cookie("token", tokenValue);
        cookie.setHttpOnly(true);
        cookie.setDomain(appDomain);
        response.addCookie(cookie);
        return createResponse();
    }
}
