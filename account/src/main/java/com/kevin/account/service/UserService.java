package com.kevin.account.service;

import com.kevin.account.bo.UserBO;

import java.util.List;

/**
 * @Author:Kevin
 * @Date:Created in 10:23 2021/4/24
 */
public interface UserService {

    int saveUsers(List<UserBO> users);

    UserBO findUserByPhone(String phone);

    int createUser(UserBO userBO);
}
