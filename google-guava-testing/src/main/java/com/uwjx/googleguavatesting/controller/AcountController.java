package com.uwjx.googleguavatesting.controller;

import com.uwjx.googleguavatesting.dto.UserDTO;
import com.uwjx.googleguavatesting.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 22:50
 */
@RestController
@Slf4j
@RequestMapping(value = "account")
public class AcountController {

    @Autowired
    UserService userService;

    @PostMapping(value = "login")
    public void add(@RequestBody UserDTO userDTO , HttpServletRequest request){


        userService.add(userDTO);
    }

}
