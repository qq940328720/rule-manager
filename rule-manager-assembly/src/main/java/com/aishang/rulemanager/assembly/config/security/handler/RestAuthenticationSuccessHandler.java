package com.aishang.rulemanager.assembly.config.security.handler;


import com.aishang.rulemanager.common.MyObjectMapper;
import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by neeke on 17-9-12.
 * 处理登录认证成功
 */
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 登录认证后生成accessToken
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        MyObjectMapper.getInstance().writeValue(httpServletResponse.getOutputStream(), new ResponseDTOWrapper(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage()));

    }
}
