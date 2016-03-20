package com.spring_28min.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * The sample of aspect.
 *
 * @author Andrei Khadziukou
 */
@Aspect
@Component
public class HiBeyAspect {

    // Pointcut with more complex condition then in the lesson 13
    @Before("execution(* com.spring_28min.service.GoodMorningService.*(..)) " +
            "|| execution(* com.spring_28min.service.GoodbyeService.*(..))")
    public void before(JoinPoint joinPoint) {
        // advice
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.spring_28min.service.GoodMorningService.*(..)) " +
            "|| execution(* com.spring_28min.service.GoodbyeService.*(..))")
    public void beforeWithArgs(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName() +
            " with arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.spring_28min.service.GoodMorningService.*(..)) " +
            "|| execution(* com.spring_28min.service.GoodbyeService.*(..)))")
    public void after(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.spring_28min.service.GoodMorningService.*(..)) " +
            "|| execution(* com.spring_28min.service.GoodbyeService.*(..)))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, String result) {
        System.out.println("After method: " + joinPoint.getSignature().getName() + "(result: " + result + ")");
    }

}
