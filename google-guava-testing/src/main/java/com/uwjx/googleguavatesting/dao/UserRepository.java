package com.uwjx.googleguavatesting.dao;

import com.uwjx.googleguavatesting.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 23:20
 */
public interface UserRepository extends CrudRepository<UserEntity , Long> {
}
