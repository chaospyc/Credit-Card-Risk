package com.chaossnow.ms.controller;


import com.chaossnow.ms.dto.RoleBean;
import com.chaossnow.ms.dto.RolePermission;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.shiro.service.AdminPermissionService;
import com.chaossnow.ms.shiro.service.AdminRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author chaos
 * @ClassName RoleController
 * @date 2022年07月30日 23:05
 * @Version 1.0
 */

@RestController
@CrossOrigin
@Api(value = "角色管理")
public class RoleController {



    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AdminPermissionService adminPermissionService;

    /**
     * 查看所有的角色
     * @return
     */
    @RequestMapping(value = "/api/admin/role",method = RequestMethod.GET)
    @ApiOperation(value = "角色清单",httpMethod = "GET")
    public Result listRoles(){
        List<AdminRole> adminRoles = adminRoleService.listRoles();
        return ResultFactory.buildSuccessResult(adminRoles);
    }

    /**
     * 更新角色的状态
     * @param requestAdminRole
     * @return
     */
    @RequestMapping(value = "/api/admin/role/status",method = RequestMethod.PUT)
    @ApiOperation(value = "更新角色状态",httpMethod = "PUT")
    public Result updateRoleStatus(@RequestBody AdminRole requestAdminRole){
        AdminRole adminRole = adminRoleService.updateRoleStatus(requestAdminRole);
        String message = "角色"+adminRole.getNameZh()+"状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }

    /**
     * 编辑角色 存在问题
     * @return
     */
    @RequestMapping(value = "/api/admin/role",method = RequestMethod.PUT)
    @ApiOperation(value = "修改角色权限信息",httpMethod = "PUT")
    public Result editRole(@RequestBody RolePermission requestRolePermission){
        //通过角色修改角色的名称，角色中文名称，以及角色所有的权限信息（多个）
        adminRoleService.editRole(requestRolePermission);
        return ResultFactory.buildSuccessResult(null);
    }

    /**
     * 增加角色
     * @return
     */
    @RequestMapping(value = "/api/admin/role",method = RequestMethod.POST)
    @ApiOperation(value = "增加角色",httpMethod = "POST")
    public Result addRole(@Valid @RequestBody RoleBean role){
        return adminRoleService.addRole(role);
        // return ResultFactory.buildSuccessResult(null);
    }

    /**
     * 增加权限
     * @return
     */
    @RequestMapping(value = "/api/admin/permission",method = RequestMethod.POST)
    @ApiOperation(value = "增加权限",httpMethod = "POST")
    public Result addRole(){
        return ResultFactory.buildSuccessResult(null);
    }

    /**
     * 查看权限清单
     * @return
     */
    @RequestMapping(value = "/api/admin/role/perm",method = RequestMethod.GET)
    @ApiOperation(value = "权限清单",httpMethod = "GET")
    public Result listPerms(){
        return ResultFactory.buildSuccessResult(adminPermissionService.listAllPermissions());
    }

    /**
     * 更新权限清单
     * @param rid
     * @param menuIds
     * @return
     */
    @RequestMapping(value = "/api/admin/role/menu",method = RequestMethod.PUT)
    @ApiOperation(value = "角色菜单",httpMethod = "PUT")
    public Result updateRoleMenu(@RequestParam int rid , @RequestBody Map<String, List<Integer>> menuIds){
        return ResultFactory.buildSuccessResult(null);
    }
}
