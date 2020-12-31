package com.uwjx.googleguavatesting.config;

import com.uwjx.googleguavatesting.intercept.LogInterceptor;
import com.uwjx.googleguavatesting.intercept.PermissionInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/31 22:24
 */
@Configuration
@Slf4j
public class TestConfig implements WebMvcConfigurer {

    @Autowired
    PermissionInterceptor permissionInterceptor;
    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.warn("处理 Interceptor");
        registry.addInterceptor(permissionInterceptor);
        registry.addInterceptor(logInterceptor);
    }
}
