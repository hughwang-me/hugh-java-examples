package com.uwjx.googleguavatesting.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 23:14
 */
@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String permissions;
}
