package com.uwjx.googleguavatesting.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.uwjx.googleguavatesting.dao.UserRepository;
import com.uwjx.googleguavatesting.dto.UserDTO;
import com.uwjx.googleguavatesting.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 22:48
 */
@Component
@Slf4j
@Order(2)
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.warn("经过 AuthFilter");
        if(StringUtils.isNotEmpty(request.getHeader("Authorization"))){
            String authorization = request.getHeader("Authorization");
            log.warn("authorization -> {}" , authorization);
            String basic = StringUtils.substringAfter(authorization , "Basic ");
            log.warn("basic -> {}" , basic);
            String decode = new String(Base64Utils.decodeFromString(basic));
            log.warn("decode -> {}" , decode);
            String[] account = StringUtils.split(decode , ":");
            String username = account[0];
            String password = account[1];


            log.warn("username -> {}" , username);
            log.warn("password -> {}" , password);

            UserEntity userEntity = userRepository.findByUsername(username);
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity , userDTO);
            request.setAttribute("user" , userDTO);
        }

        filterChain.doFilter(request , response);
    }
}
