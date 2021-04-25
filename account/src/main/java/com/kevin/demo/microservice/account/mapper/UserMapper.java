package com.kevin.demo.microservice.account.mapper;

import com.kevin.demo.microservice.account.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:Kevin
 * @Date:Created in 15:59 2021/4/24
 */
public interface UserMapper {

    UserEntity findUserByPhone(@Param("phone") String phone);
}
