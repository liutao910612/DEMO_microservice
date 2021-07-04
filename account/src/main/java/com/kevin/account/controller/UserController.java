package com.kevin.account.controller;

import com.kevin.account.bo.UserBO;
import com.kevin.account.service.UserService;
import com.kevin.account.vo.UserVO;
import com.kevin.util.web.ResponseBuilder;
import com.kevin.util.web.RestfulDataResponse;
import com.kevin.util.web.RestfulResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:Kevin
 * @Date:Created in 7:54 2021/4/24
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //this bean will be created by spring application context when add the starter-netflix-ribbon dependency
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")
    public RestfulDataResponse findUser(
            @RequestParam("phone") String phone) {
        UserBO user = userService.findUserByPhone(phone);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResponseBuilder.buildOkDataResponse(userVO);
    }

    @PostMapping("user")
    public RestfulDataResponse create(@RequestBody UserBO userBO) {

        int count = userService.createUser(userBO);
        return ResponseBuilder.buildOkDataResponse(count);
    }

    @DeleteMapping("user/{userId}")
    public RestfulDataResponse deleteUser(@PathVariable int userId) {
        String result = restTemplate.getForObject("http://kevin-finance/consumption/totalMoney/" + userId, String.class);
        log.info("result:" + result);
        return ResponseBuilder.buildOkDataResponse(result);
    }
}
