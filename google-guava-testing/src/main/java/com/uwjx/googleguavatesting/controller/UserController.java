package com.uwjx.googleguavatesting.controller;

import com.uwjx.googleguavatesting.dto.UserDTO;
import com.uwjx.googleguavatesting.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 22:50
 */
@RestController
@Slf4j
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void add(@RequestBody UserDTO userDTO){
        userService.add(userDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody UserDTO userDTO){
        userService.delete(userDTO);
    }

    @PutMapping
    public void update(@RequestBody UserDTO userDTO){
        userService.modify(userDTO);
    }

    @GetMapping
    public List<UserDTO> list(@RequestBody UserDTO userDTO){
        return userService.list(userDTO);
    }
}
