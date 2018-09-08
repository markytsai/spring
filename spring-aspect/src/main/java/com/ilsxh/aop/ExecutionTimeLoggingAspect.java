package com.ilsxh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Aspect
public class ExecutionTimeLoggingAspect {

    @Around("execution(public * * (..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.nanoTime();

        String className = pjp.getTarget().getClass().getCanonicalName();
        String methodName = pjp.getSignature().getName();

        Object output = pjp.proceed();

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Execution of " + className + "#" + methodName + " ended in " + new BigDecimal(elapsedTime)
                .divide(new BigDecimal(1000000)) + " milliseconds");

        return output;
    }
}
