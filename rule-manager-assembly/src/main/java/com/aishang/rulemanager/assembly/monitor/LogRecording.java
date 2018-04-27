package com.aishang.rulemanager.assembly.monitor;

import com.aishang.rulemanager.facade.dto.request.Log.OperationLogRequestDTO;
import com.aishang.rulemanager.facade.service.IOperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogRecording {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformenceMonitor.class);
    @Autowired
    private IOperationLogService iOperationLogService;

    /**
     * 业务逻辑层切入点
     */
    @Pointcut("@annotation(com.aishang.rulemanager.common.inrerface.Logs)")
    private void poincutLog() {

    }


    @After("poincutLog()")
    public Object logBefore(JoinPoint joinPoint) throws Exception {
        String method = joinPoint.getSignature().getName();
        OperationLogRequestDTO operationLog = new OperationLogRequestDTO();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        operationLog.setUri(httpServletRequest.getRequestURI());//uri地址
        operationLog.setMethod(method);//方法名称
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        operationLog.setOperator(principal);//当前登录人账号
        operationLog.setOperatedAt(System.currentTimeMillis());//获取时间
        iOperationLogService.operationLogIntsert(operationLog);
        return joinPoint;
    }
}
