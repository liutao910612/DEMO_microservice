package com.kevin.finance.controller;

import com.kevin.util.web.ResponseBuilder;
import com.kevin.util.web.RestfulDataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author:Kevin
 * @Date:Created in 16:44 2021/7/3
 */
@RestController
@RequestMapping("/consumption")
public class ConsumptionController {

    @GetMapping("/totalMoney/{userId}")
    public RestfulDataResponse getTotalMoney(@PathVariable int userId){
        return ResponseBuilder.buildOkDataResponse(new BigDecimal(20));

    }
}
