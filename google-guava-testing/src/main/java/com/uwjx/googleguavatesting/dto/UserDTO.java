package com.uwjx.googleguavatesting.dto;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 23:14
 */
@Data
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String permissions;
}
