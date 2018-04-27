package com.aishang.rulemanager.assembly.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformenceMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformenceMonitor.class);
    /**
     * 业务逻辑层切入点
     */
    @Pointcut("execution(* com.aishang.rulemanager.adapter..*.*(..))")
    private void pointCut4Service() {

    }

    /**
     * 计算方法耗时
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCut4Service()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.debug("{}.{}耗时：{}毫秒", proceedingJoinPoint.getTarget().getClass().getName(), proceedingJoinPoint.getSignature().getName(),(end - begin));
        return o;
    }


}
