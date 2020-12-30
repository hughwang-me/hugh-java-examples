package com.uwjx.googleguavatesting.service.impl;

import com.google.common.collect.Lists;
import com.uwjx.googleguavatesting.dao.UserRepository;
import com.uwjx.googleguavatesting.dto.UserDTO;
import com.uwjx.googleguavatesting.entity.UserEntity;
import com.uwjx.googleguavatesting.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/30 23:22
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void add(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties( userDTO , userEntity);
        userRepository.save(userEntity);
    }

    @Override
    public void delete(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties( userDTO , userEntity);
        userRepository.delete(userEntity);
    }

    @Override
    public void modify(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties( userDTO , userEntity);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> list(UserDTO userDTO) {
        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<UserDTO> userDTOList = Lists.newArrayList();
        userEntities.forEach(userEntity -> {
            UserDTO userDTOItem = new UserDTO();
            BeanUtils.copyProperties(userEntity , userDTOItem);
            userDTOList.add(userDTOItem);
        });
        return userDTOList;
    }
}
