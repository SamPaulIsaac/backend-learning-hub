package com.sam.aspect.interfaceAnnotation.config;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // This advice will run before any method annotated with @LogExecutionTime
    @Before("@annotation(LogExecutionTime)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before execution of method: " + joinPoint.getSignature().getName());
    }

    // This advice will run after any method annotated with @LogExecutionTime
    @After("@annotation(LogExecutionTime)")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After execution of method: " + joinPoint.getSignature().getName());
    }

    // This advice will run after any method annotated with @LogExecutionTime completes successfully
    @AfterReturning("@annotation(LogExecutionTime)")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("After returning from method: " + joinPoint.getSignature().getName());
    }

    // This advice will wrap around any method annotated with @LogExecutionTime
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("Around advice start for method: " + joinPoint.getSignature().getName());

        Object proceed = joinPoint.proceed(); // Proceed with the method execution

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        System.out.println("Around advice end for method: " + joinPoint.getSignature().getName());

        return proceed;
    }
}
