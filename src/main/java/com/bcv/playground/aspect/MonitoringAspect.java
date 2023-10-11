package com.bcv.playground.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class MonitoringAspect {

	@Around("@annotation(Monitored)")
    public Object monitor(ProceedingJoinPoint joinPoint) throws Throwable {
		String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String targetMethod = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.info("Executing {}.{} with arguments: {}", targetClass, targetMethod, args);

        Object response = joinPoint.proceed();

        log.info("Method returned: {}", response);
      
        return response;
    }
	
}
