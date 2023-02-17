package com.example.practice_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Configuration
@Aspect
public class ServiceAspect {
    private Logger logger = (Logger) LoggerFactory.getLogger(ServiceAspect.class);

    @Before("execution(* com.example.practice_aop.service.DepartmentService.getDepartmentDto(..))")
    public void beforeCallDepartmentService(JoinPoint joinPoint){
        logger.info("before called method " + joinPoint.toString());
    }

    @After("execution(* com.example.practice_aop.service.DepartmentService.getDepartmentDto(..))")
    public void afterCallDepartmentService(JoinPoint joinPoint) {
        logger.info("after called method " + joinPoint.toString());
    }

    @AfterThrowing("execution(* com.example.practice_aop.service.EmployeeService.*(..))")
    public void afterCallEmployeeServiceUnSuccess(JoinPoint joinPoint) {
        logger.error("after call failed method: " + joinPoint.toString());
    }
}
