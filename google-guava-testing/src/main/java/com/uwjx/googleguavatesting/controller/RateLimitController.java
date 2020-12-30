package com.uwjx.googleguavatesting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 22:50
 */
@RestController
@Slf4j
@RequestMapping(value = "rateLimit")
public class RateLimitController {

    @GetMapping
    public String list(){

        log.warn("流量限制测试 list");
        return "rate limit list success";
    }
}
