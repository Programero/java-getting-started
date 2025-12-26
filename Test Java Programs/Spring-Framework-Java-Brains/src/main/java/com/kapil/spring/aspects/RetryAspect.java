package com.kapil.spring.aspects;

import com.kapil.spring.annotations.Retry;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class RetryAspect {

    //    @Around("execution(public void draw())")
    @Around("@annotation(retryAnnotation)")
    public Object retryLogic(ProceedingJoinPoint pjp, Retry retryAnnotation) throws Throwable{
        System.out.println("In retryLogic Aspect");
        System.out.println("Retry Annotation: " + retryAnnotation);
        System.out.println("retryLogic called with max_retries: " + retryAnnotation.max_retries());
        int numOfAttempts = 0;
        Exception ex = null;
        do {
            numOfAttempts++;
            System.out.println("Attempt Number: "+numOfAttempts);
            try{
                return pjp.proceed();
            }catch(Exception exc){
                ex = exc;
            }
        } while(numOfAttempts < retryAnnotation.max_retries());
        throw ex;
    }
}
