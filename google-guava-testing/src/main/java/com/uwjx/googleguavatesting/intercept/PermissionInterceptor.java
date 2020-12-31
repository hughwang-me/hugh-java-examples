package com.uwjx.googleguavatesting.intercept;


import com.uwjx.googleguavatesting.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/31 22:19
 */
@Component
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.warn("PermissionInterceptor preHandle");
        UserDTO userDTO = (UserDTO) request.getAttribute("user");
        if(null == userDTO){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("未登录访问 PermissionInterceptor");
            response.getWriter().flush();
            return false;
        }
        if(StringUtils.equalsIgnoreCase(request.getMethod() , "get") && !StringUtils.contains(userDTO.getPermissions() , "r")){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("您无权访问 PermissionInterceptor");
            response.getWriter().flush();
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.warn("PermissionInterceptor afterCompletion");
    }
}
