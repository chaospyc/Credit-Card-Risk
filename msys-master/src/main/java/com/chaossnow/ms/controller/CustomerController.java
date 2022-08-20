package com.chaossnow.ms.controller;

import com.chaossnow.ms.dao.CustomerDao;
import com.chaossnow.ms.dto.CustomerVO;
import com.chaossnow.ms.pojo.User;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: bankcard-master
 * @description: 客户管理
 * @author: chaos
 * @create: 2022-08-17 23:20
 **/



@RestController
@CrossOrigin
@Api("客户管理")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    /**
     * CustomerVO 需要进行数据校验
     * @param customerVO
     * @return
     */
    @RequestMapping(value = "/api/customer/add",method = RequestMethod.POST)
    @ApiOperation(value = "增加客户",httpMethod = "POST")
    public Result addCustomer(@RequestBody CustomerVO customerVO){
        return customerService.addCustomer(customerVO);
    }

    @RequestMapping(value = "/api/customer/delete/{id}",method = RequestMethod.POST)
    @ApiOperation(value = "客户注销",httpMethod = "POST")
    public Result deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomerByCustomerId(id);
        return ResultFactory.buildSuccessResult("用户注销成功");
    }

    /**
     * 设置一个常量类
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/customer/setState/{state}",method = RequestMethod.POST)
    @ApiOperation(value = "设置客户等级",httpMethod = "POST")
    public  Result setState(@PathVariable("state") Long id){
        return null;
    }

    @RequestMapping(value = "/api/customer/listCustomer")
    @ApiOperation(value = "客户列表",httpMethod = "GET")
    public Result listCustomer(){
        CustomerVO customerVO = customerService.listAllCustomer();
        return ResultFactory.buildSuccessResult(customerVO);
    }

    @RequestMapping(value = "/api/customer/getCustomer/{name}",method = RequestMethod.POST)
    @ApiOperation(value = "获取客户信息",httpMethod = "POST")
    public Result getCustomerByname(){
        return null;
    }
    @RequestMapping(value = "/api/customer/listRisk",method = RequestMethod.GET)
    @ApiOperation(value = "查看风险等级",httpMethod = "GET")
    public Result listRisk(@PathVariable("id") Long id){
        return null;
    }


}
