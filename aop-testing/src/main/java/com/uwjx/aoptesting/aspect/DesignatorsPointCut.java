package com.uwjx.aoptesting.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DesignatorsPointCut {

    @Pointcut("execution(* com.uwjx.aoptesting.service.TestService.*(..))")
    public void pointCut(){

    }
}
