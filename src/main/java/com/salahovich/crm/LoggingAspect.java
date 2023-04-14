package com.salahovich.crm;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.salahovich.crm.*.*(..))")
    public void packageAdvice(){}

    @Before("packageAdvice()")
    public void beforeMethods(JoinPoint point){
        String theMethod = point.getSignature().toShortString();
        
        myLogger.info("Before Returning " + theMethod.toString());
    }

    @AfterReturning("packageAdvice()")
    public void afterMethods(JoinPoint point){
        String theMethod = point.getSignature().toShortString();
        
        myLogger.info("After Returning " + theMethod.toString());
    }
}
