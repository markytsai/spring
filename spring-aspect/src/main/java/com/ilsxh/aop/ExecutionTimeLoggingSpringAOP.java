package com.ilsxh.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class ExecutionTimeLoggingSpringAOP implements MethodBeforeAdvice, AfterReturningAdvice {

    long startTime = 0;

    @Override
    public void afterReturning(@Nullable Object o, Method method, Object[] objects, @Nullable Object o1) throws Throwable {
        long elapsedTime = System.nanoTime() - startTime;
        String className = o1.getClass().getCanonicalName();
        String methodName = method.getName();
        System.out.println("Execution of " + className + "#" + methodName + " ended in " + new BigDecimal(elapsedTime)
                .divide(new BigDecimal(1000000)) + " milliseconds");
    }

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        startTime = System.nanoTime();
    }
}
