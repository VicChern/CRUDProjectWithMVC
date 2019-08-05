package com.company.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //    set logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //    setup pointcat declarations
    @Pointcut("execution(* com.company.controller.*.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.company.service.*.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.company.dao.*.*.*(..))")
    private void forDAOPackage() {

    }

    @Pointcut("forControllerPackage() || forDAOPackage()|| forServicePackage()")
    private void forAppFlow() {

    }

    //    add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("In @Before calling method: " + method);

//        display the arguments to the method

//        get the arguments

        Object [] args = joinPoint.getArgs();
//        loop thru and display args

        for (Object arg: args){
            System.out.println("========> argument " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut="forAppFlow()",
            returning="theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=====>> in @AfterReturning: from method: " + theMethod);

        // display data returned
        logger.info("=====>> result: " + theResult);

    }

}
