package com.aishang.rulemanager.assembly.config.security.handler;


import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by neeke on 17-9-12.
 * 处理认证异常
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setContentType("application/json");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ErrorCode errorCode = ErrorCode.AUTHENTICATION_EXCEPTION;
        objectMapper.writeValue(httpServletResponse.getOutputStream(), new ResponseDTOWrapper(errorCode.getCode(), errorCode.getMessage()));

//        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
