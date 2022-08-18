package com.chaossnow.ms.controller;


import com.chaossnow.ms.dto.UserDTO;
import com.chaossnow.ms.pojo.User;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.service.AdminUserRoleService;
import com.chaossnow.ms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Api("用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserRoleService adminUserRoleService;

    /**
     * 展示所有的用户信息
     * 展示所有信息这里需要得到shiro授权
     * @return
     */
    @RequestMapping(value = "/api/admin/user",method = RequestMethod.GET)
    @ApiOperation(value = "用户信息",httpMethod = "GET")
    public Result listUsers(){
        List<UserDTO> userList = userService.listAllUsers();
        return ResultFactory.buildSuccessResult(userList);
    }

    /**
     * 更新用户的状态
     * @param requestUser
     * @return
     */
    @RequestMapping(value = "/api/admin/user/status",method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户的状态",httpMethod = "PUT")
    public Result updateUserStatus(@Validated  @RequestBody User requestUser){
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult(null);
    }

    /**
     * 重新设置密码
     * @param requestUser
     * @return
     */
    @RequestMapping(value = "api/admin/user/password",method = RequestMethod.PUT)
    @ApiOperation(value = "重设用户密码",httpMethod = "PUT")
    public Result resetPassword(@RequestBody User requestUser){
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("密码重设成功");
    }


    /**
     * 修改用户信息
     * @param requestUser
     * @return
     */
    @RequestMapping(value = "/api/admin/user",method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户的信息",httpMethod = "PUT")
    public Result editUser(@RequestBody UserDTO requestUser){
        UserDTO userDTO = userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("用户信息修改成功");

    }

}
