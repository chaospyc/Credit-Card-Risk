package com.chaossnow.ms.controller;

import com.chaossnow.ms.pojo.User;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.shiro.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


/**
 * @author chaos
 * @ClassName LoginController
 * @date 2022年07月30日 23:05
 * @Version 1.0
 */

@RestController
@CrossOrigin
@Api(value = "登录管理")
public class LoginController {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Result test(){
        return ResultFactory.buildSuccessResult("成功");
    }
    /**
     * 登录api
     * @param requestUser
     * @return
     */
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录管理",httpMethod = "POST")
    public Result login(@RequestBody  User requestUser) {
        String username = requestUser.getUsername();
        //http进行转义
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);

        try{
            subject.login(usernamePasswordToken);
            User user = userService.findByUsername(username);
            if(!user.isEnabled()){
                return ResultFactory.buildFailResult("该账户已禁用");
            }

            return ResultFactory.buildSuccessResult(username);

        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }

    }


    /**
     * 注册api
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/register",method = RequestMethod.POST)
    @ApiOperation(value = "注册管理",httpMethod = "POST")
    public Result register(@RequestBody User user){
        int status = userService.register(user);
        switch (status){
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }


    /**
     * 退出api
     * @return
     */
    @RequestMapping(value = "/api/logout",method = RequestMethod.GET)
    @ApiOperation(value = "用户退出",httpMethod = "GET")
    public Result logout(){
        return null;
    }


    /**
     * 身份认证api
     * @return
     */
    @RequestMapping(value = "/api/authentication",method = RequestMethod.GET)
    @ApiOperation(value = "身份认证",httpMethod = "GET")
    public String authentication(){
        return "身份认证成功";
    }

}
