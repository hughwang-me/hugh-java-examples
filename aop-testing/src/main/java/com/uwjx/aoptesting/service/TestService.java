package com.uwjx.aoptesting.service;

import com.uwjx.aoptesting.commons.TestAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    public void run(){
        log.warn("TestService run execute ...");
    }

    @TestAnnotation
    public void runAnnotation(){
        log.warn("TestService runAnnotation ...");
    }
}
