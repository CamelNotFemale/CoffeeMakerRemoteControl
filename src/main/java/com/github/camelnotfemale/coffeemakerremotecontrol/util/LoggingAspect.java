package com.github.camelnotfemale.coffeemakerremotecontrol.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Pointcut("@annotation(CustomLog)")
    public void stringProcessingMethods() {
    }

    @AfterReturning(pointcut = "stringProcessingMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info(result.toString());
    }
}
