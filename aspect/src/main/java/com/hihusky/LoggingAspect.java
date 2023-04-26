package com.hihusky;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

public class LoggingAspect {
    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable {

        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        long endTime = System.nanoTime();

        System.out.println(joinPoint.getSignature().getName() + " executed in " + (endTime - startTime) + " ns");

        return result;
    }
}
