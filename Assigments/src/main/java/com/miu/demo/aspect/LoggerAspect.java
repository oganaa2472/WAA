package com.miu.demo.aspect;

import com.miu.demo.repository.LoggerRepo;
import com.miu.demo.repository.PostRepo;
import com.miu.demo.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {


    private final LoggerService loggerService;

    public LoggerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    //This point cut will execute where ever the annotation is placed
    @Pointcut("@annotation(LogMe)")
    public void logMeAnnotation(){}
    @Pointcut("execution(* com.miu.demo.controller.CommentController.*(..)) || " +
            "execution(* com.miu.demo.controller.PostController.*(..)) || " +
            "execution(* com.miu.demo.controller.UserController.*(..))")
    public void logMe() {
    }

//    @Before("logMeAnnotation()")
//    public void logBeforeByAnnotation(JoinPoint joinPoint){
//        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
//    }
//
//    @After("logMeAnnotation()")
//    public void logAfterByAnnotation(JoinPoint joinPoint){
//        System.out.println("Log after the method: " + joinPoint.getSignature().getName());
//    }

    // This point cut will execute according to the given designations


//    @Pointcut("@args(edu.miu.springaop.aspect.annotation.LogMe)")
//    public void logMeAnnotation2() {
//
//    }

//    // This point cut will execute according to the given designations
//    @Pointcut("target(edu.miu.springaop.controller.ProductController)")
//    public void logMe() {
//    }

//    // This point cut will execute according to the given designations
//    @Pointcut("execution( * *.*.*(..))")
//    public void logMe() {
//    }

//    // This point cut will execute according to the given designations //  edu.miu.springaop
//    @Pointcut("within(edu.miu.springaop.controller.ProductController)")
//    public void logMe() {
//    }


    @After("logMe()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
        loggerService.logOperation(joinPoint.getSignature().getName());
    }




//    @Around("execution(* edu.miu.springaop.controller.ProductController.*(..))")
//    public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("BEFORE Log around:" + proceedingJoinPoint.getSignature().getName());
//        proceedingJoinPoint.proceed();
//        System.out.println("AFTER Log around:" + proceedingJoinPoint.getSignature().getName());
//    }

}
