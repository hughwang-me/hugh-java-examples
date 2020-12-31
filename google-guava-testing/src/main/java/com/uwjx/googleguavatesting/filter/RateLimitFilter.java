package com.uwjx.googleguavatesting.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 22:48
 */
@Component
@Slf4j
@Order(1)
public class RateLimitFilter extends OncePerRequestFilter {

    private RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.warn("经过 RateLimitFilter");
        if(rateLimiter.tryAcquire()){
            filterChain.doFilter(request , response);
        }else {
//            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.getWriter().write("请求次数过多");
            response.getWriter().flush();
        }

    }
}
