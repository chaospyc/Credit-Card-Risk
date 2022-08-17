package com.chaossnow.ms.controller;


import com.chaossnow.ms.pojo.AdminMenu;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.shiro.service.AdminMenuService;
import com.chaossnow.ms.shiro.service.AdminRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 这里是菜单控制
 */
@RestController
@CrossOrigin
@Api("菜单控制")
public class MenuController {

    @Autowired
    private AdminMenuService adminMenuService;

    @Autowired
    private AdminRoleService adminRoleService;


   @RequestMapping(value = "/api/menu",method = RequestMethod.GET)
    @ApiOperation(value = "获得当前用户的菜单",httpMethod = "GET")
   public Result menu(){
       List<AdminMenu> adminMenus = adminMenuService.listByUsername();
       return ResultFactory.buildSuccessResult(adminMenus);
   }

   @RequestMapping(value = "/api/menu/role/menu",method = RequestMethod.GET)
   @ApiOperation(value = "获得当前用户的所有角色",httpMethod = "GET")
    public Result ListAllMenus(){
       List<AdminRole> adminRoles = adminRoleService.listRolesByCurrUser();
       return ResultFactory.buildSuccessResult(adminRoles);
   }
}
