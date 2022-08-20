package com.chaossnow.ms.controller;

import com.chaossnow.ms.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bankcard-master
 * @description: 用户管理
 * @author: chaos
 * @create: 2022-08-17 23:13
 **/

@RestController
@CrossOrigin
@Api("信用卡账户管理")
public class AccountController {

    @RequestMapping(value = "/api/account/add",method = RequestMethod.POST)
    @ApiOperation(value = "开立信用卡账户",httpMethod = "POST")
    public Result add(){
        //用户
        //账户
        return null;
    }

    @RequestMapping(value = "/api/account/isenabled",method = RequestMethod.PUT)
    @ApiOperation(value ="停用信用卡账户",httpMethod = "PUT")
    public Result setEnabled(){
        return null;
    }

    @RequestMapping(value = "/api/account/listAllCard",method = RequestMethod.PUT)
    @ApiOperation(value ="信用卡账户信息",httpMethod = "PUT")
    public Result listAllCard(){
        return null;
    }

    @RequestMapping(value = "/api/account/delete{id}",method = RequestMethod.PUT)
    @ApiOperation(value ="信用卡注销",httpMethod = "PUT")
    public Result deleteAccount(){
        return null;
    }

    @RequestMapping(value = "/api/account/sumLoadOfBank",method = RequestMethod.POST)
    @ApiOperation(value = "查看二级支行信用卡总规模",httpMethod = "POST")
    public Result sumLoadOfBank(){
        return null;
    }

    @RequestMapping(value = "/api/account/riskPercent",method = RequestMethod.PUT)
    @ApiOperation(value = "查看全行各账户类型比例",httpMethod = "GET")
    public Result riskPercent(){
        return null;
    }

    @RequestMapping(value = "/api/account/getAccount",method = RequestMethod.PUT)
    @ApiOperation(value = "查看客户信息" ,httpMethod = "PUT")
    public Result getAccount(){
        return null;
    }

}
