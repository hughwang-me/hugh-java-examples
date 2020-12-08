package com.uwjx.aoptesting;

import com.uwjx.aoptesting.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAspect {

    @Autowired
    TestService testService;

    @Test
    public void run(){
//        testService.run();
        testService.runAnnotation();
    }
}
