package com.chaossnow.ms.shiro.service.impl;

import com.chaossnow.ms.dao.AdminRoleDao;
import com.chaossnow.ms.dao.UserDao;
import com.chaossnow.ms.dto.RoleBean;
import com.chaossnow.ms.dto.RolePermission;
import com.chaossnow.ms.dto.UserRole;
import com.chaossnow.ms.pojo.AdminPermission;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.pojo.AdminUserRole;
import com.chaossnow.ms.result.Result;
import com.chaossnow.ms.result.ResultFactory;
import com.chaossnow.ms.shiro.service.AdminRolePermissionService;
import com.chaossnow.ms.shiro.service.AdminRoleService;
import com.chaossnow.ms.shiro.service.AdminUserRoleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @ClassName AdminRoleServiceImpl
 * @date 2022年08月05日 23:58
 * @Version 1.0
 */

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;
    @Autowired
    private UserDao userDao;

    // @Autowired
    // private UserService userService;
    @Autowired
    private AdminUserRoleService adminUserRoleService;
    @Autowired
    private AdminRolePermissionService adminRolePermissionService;


    @Override
    public List<AdminRole> listRolesByUser(String username) {
        //根据用户名获得用户的角色
        //1.根据用户名获得用户的id
        Long uid =  userDao.findByUsername(username).getId();
        //2，根据用户uid查所有的rid列表

        List<Long> rids = adminUserRoleService.findByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        for(Long rid:rids) {
            System.out.println(rid);
        }
        return adminRoleDao.findAllById(rids);
    }

    @Override
    public List<AdminRole> listRolesByCurrUser() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return null;
    }

    @Override
    public List<AdminRole> listRoles() {
        return adminRoleDao.listRoles();
    }

    @Override
    @Transactional
    public AdminRole updateRoleStatus(AdminRole requestAdminRole) {
        AdminRole adminRoleInDB = adminRoleDao.getByName(requestAdminRole.getName());
        adminRoleInDB.setEnabled(requestAdminRole.getEnabled());
        adminRoleDao.updateRoleStatus(adminRoleInDB);
        return adminRoleInDB;

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editRole(RolePermission requestRolePermission) {

        //一个角色对应多个权限 一个rid 多个 pid
        AdminRole adminRoleInDB = adminRoleDao.getByName(requestRolePermission.getName());
        RolePermission rolePermission = (RolePermission) new RolePermission().convertFrom(adminRoleInDB);
        List<AdminPermission> adminPermissions = adminRolePermissionService.listPermissionsByRole(requestRolePermission.getName());
        rolePermission.setAdminPermissions(adminPermissions);


        //8月14日晚工作到此

        // List<AdminPermission> adminPermissions = adminPremissionDao.listByRid(rolePermission.getId());


        // userDTO = (UserDTO) requestAdminRole.getName();
    //    1、获取角色信息
    //    2、获取角色对应的权限信息
    //    3、修改角色信息
    //    4、修改角色对应的权限信息

    }

    @Override
    public UserRole getRolesByUser(String username) {
        Long uid = userDao.findByUsername(username).getId();
        return null;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Result addRole(RoleBean role) {
        AdminRole adminRole = new AdminRole(role);
        try{
            adminRoleDao.insertRole(adminRole);
            return ResultFactory.buildSuccessResult("角色创建成功");
        }catch (Exception e){
            e.printStackTrace();
            //出错则事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultFactory.buildFailResult("Error");
        }
    }
}
