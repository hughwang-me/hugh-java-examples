package com.uwjx.aoptesting.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {

    @Pointcut("within(com.uwjx.aoptesting.service.TestService)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        log.warn("MyAspect before execute......");
    }
}
