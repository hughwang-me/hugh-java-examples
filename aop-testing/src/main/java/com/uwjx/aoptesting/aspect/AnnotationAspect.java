package com.uwjx.aoptesting.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AnnotationAspect {

    @Pointcut("@annotation(com.uwjx.aoptesting.commons.TestAnnotation)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        log.warn("AnnotationAspect before execute......");
    }
}
