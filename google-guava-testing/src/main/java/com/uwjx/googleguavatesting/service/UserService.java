package com.uwjx.googleguavatesting.service;

import com.uwjx.googleguavatesting.dto.UserDTO;

import java.util.List;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 23:20
 */
public interface UserService {

    void add(UserDTO userDTO);

    void delete(UserDTO userDTO);

    void modify(UserDTO userDTO);

    List<UserDTO> list(UserDTO userDTO);
}
