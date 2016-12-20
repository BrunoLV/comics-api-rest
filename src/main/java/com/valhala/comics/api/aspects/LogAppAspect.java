package com.valhala.comics.api.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAppAspect {

    @Around("execution(* com.valhala.comics.api.rest.*.*(..))")
    public void logExecucao(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("****** Executando o método: " + joinPoint.getSignature().getName() + " ******");
        joinPoint.proceed();
        System.out.println("******Terminou a execução do método: " + joinPoint.getSignature().getName() + " ******");
    }

}
