package com.chaossnow.ms.controller;

import com.chaossnow.ms.pojo.User;
import com.chaossnow.ms.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @program: bankcard-master
 * @description: 客户管理
 * @author: chaos
 * @create: 2022-08-17 23:20
 **/



@RestController
@CrossOrigin
@Api("消费者管理")
public class CustomerController {

    @RequestMapping(value = "/api/customer/add",method = RequestMethod.POST)
    @ApiOperation(value = "增加客户",httpMethod = "POST")
    public Result addCustomer(@RequestBody User requestUser){
        return null;
    }

    @RequestMapping(value = "/api/customer/delete{id}",method = RequestMethod.POST)
    @ApiOperation(value = "客户注销",httpMethod = "POST")
    public Result deleteCustomer(@RequestBody User requestUser){
        return null;
    }
}
