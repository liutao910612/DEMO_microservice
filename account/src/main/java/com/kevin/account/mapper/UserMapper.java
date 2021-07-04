package com.kevin.account.mapper;

import com.kevin.account.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:Kevin
 * @Date:Created in 15:59 2021/4/24
 */
public interface UserMapper {

    UserEntity findUserByPhone(@Param("phone") String phone);
}
