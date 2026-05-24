package com.restaurant.ex4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.restaurant.ex4.service.*.*(..))",
            throwing = "ex"
    )
    public void logError(
            JoinPoint joinPoint,
            Exception ex
    ) {

        System.out.println("====== SECURITY LOG ======");

        System.out.println(
                "Class: "
                        + joinPoint.getTarget()
                        .getClass()
                        .getSimpleName()
        );

        System.out.println(
                "Method: "
                        + joinPoint.getSignature().getName()
        );

        System.out.println(
                "Error: " + ex.getMessage()
        );

        System.out.println("==========================");
    }
}