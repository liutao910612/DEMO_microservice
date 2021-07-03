package com.kevin.demo.microservice.account.controller;

import com.kevin.demo.microservice.account.bo.UserBO;
import com.kevin.demo.microservice.account.service.UserService;
import com.kevin.demo.microservice.account.vo.UserVO;
import com.kevin.util.web.ResponseBuilder;
import com.kevin.util.web.RestfulDataResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Kevin
 * @Date:Created in 7:54 2021/4/24
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("user")
    public RestfulDataResponse findUser(
            @RequestParam("phone") String phone){
        UserBO user = userService.findUserByPhone(phone);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return ResponseBuilder.buildOkDataResponse(userVO);
    }

    @PostMapping("user")
    public RestfulDataResponse create(@RequestBody UserBO userBO){

        int count = userService.createUser(userBO);
        return ResponseBuilder.buildOkDataResponse(count);
    }
}
