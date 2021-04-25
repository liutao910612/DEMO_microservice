package com.kevin.demo.microservice.account.service.impl;

import com.kevin.demo.microservice.account.bo.UserBO;
import com.kevin.demo.microservice.account.bo.UserQueryBO;
import com.kevin.demo.microservice.account.entity.UserEntity;
import com.kevin.demo.microservice.account.mapper.UserMapper;
import com.kevin.demo.microservice.account.service.UserService;
import com.kevin.demo.microservice.common.component.EmailComponent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author:Kevin
 * @Date:Created in 10:25 2021/4/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailComponent emailComponent;

    @Override
    public int saveUsers(List<UserBO> users) {
        return 0;
    }

    @Override
    public UserBO findUserByPhone(String phone) {
        UserQueryBO userQuery = new UserQueryBO();
        userQuery.setPhone(phone);
        UserEntity userEntity = userMapper.findUserByPhone(phone);
        UserBO user = new UserBO();
        if (ObjectUtils.isEmpty(userEntity)) {
            return null;
        }

        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public int createUser(UserBO userBO) {

        //TODO

        emailComponent.sendEmail(userBO.getEmail(),null,null,null);
        return 0;
    }
}
