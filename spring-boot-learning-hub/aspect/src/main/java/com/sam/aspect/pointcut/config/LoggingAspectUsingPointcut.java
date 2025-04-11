package com.sam.aspect.pointcut.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectUsingPointcut {

    @Pointcut("execution(* com.sam.aspect.pointcut.controller.UsingPointcutController.*(..))")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void logBefore() {
        System.out.println("Method is about to be called");
    }

    @Around("controllerMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice start");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); // Proceed with the method execution
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        System.out.println("Around Advice End");
        return proceed;
    }

    @After("controllerMethods()")
    public void logAfter() {
        System.out.println("Method has been called");
    }

    @AfterReturning(pointcut = "execution(* com.sam.aspect.pointcut.controller.UsingPointcutController  .*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("Method executed successfully." + result);
    }
}
