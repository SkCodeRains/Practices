package com.in28minutes.learnspringaop.aopexampl.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogginAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.in28minutes.learnspringaop.aopexampl.*.*.*(..))")
    public void logMethodCall(JoinPoint jointPoint) {
        logger.info("before - method call", jointPoint);
    }

}
