package com.eazybytes.eazyschool.aspects;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* com.eazybytes.eazyschool..*.*(..))")
    public Object log(final ProceedingJoinPoint joinPoint) throws Throwable {
        LoggerAspect.log.info(joinPoint.getSignature().toString() + " method execution start");
        final Instant start = Instant.now();
        final Object returnObj = joinPoint.proceed();
        final Instant finish = Instant.now();
        final long timeElapsed = Duration.between(start, finish).toMillis();
        LoggerAspect.log
                .info("Time took to execute " + joinPoint.getSignature().toString() + " method is : " + timeElapsed);
        LoggerAspect.log.info(joinPoint.getSignature().toString() + " method execution end");
        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.eazybytes.eazyschool.*.*(..))", throwing = "ex")
    public void logException(final JoinPoint joinPoint, final Exception ex) {
        LoggerAspect.log.error(joinPoint.getSignature() + " An exception happened due to : " + ex.getMessage());
    }

}
