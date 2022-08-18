package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.AdminPremissionDao;
import com.chaossnow.ms.pojo.AdminPermission;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.service.AdminPermissionService;
import com.chaossnow.ms.service.AdminRolePermissionService;
import com.chaossnow.ms.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @ClassName AdminPermissionServiceImpl
 * @date 2022年08月02日 21:46
 * @Version 1.0
 */

@Service
public class AdminPermissionServiceImpl implements AdminPermissionService {

    @Autowired
    private AdminPremissionDao adminPremissionDao;

    @Autowired
    private AdminRoleService adminRoleService;


    @Autowired
    private AdminRolePermissionService adminRolePermissionService;


    @Override
    public List<AdminPermission> listAllPermissions() {
        List<AdminPermission> adminPermissions = adminPremissionDao.listAllPermissions();
        return adminPermissions;
    }

    @Override
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> adminPermissions = adminPremissionDao.listAllPermissions();
        for(AdminPermission adminPermission:adminPermissions){
            //匹配前缀
            if(requestAPI.startsWith(adminPermission.getUrl())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> listPermissionURLsByUser(String username) {
        //此方法在实际开发中不可取 sql效率很低
        List<AdminRole> adminRoles = adminRoleService.listRolesByUser(username);
        Set<String> permissAPIS = listPermissionURLsByRoles(adminRoles);
        // Set<String> requestAPIs = urlDao.listRolesByUser(username);
        return permissAPIS;
    }

    @Override
    public Set<String> listPermissionURLsByRoles(List<AdminRole> adminRoles) {
        List<AdminPermission> adminPermissions = adminRolePermissionService.listPermissionsByRoles(adminRoles);
        Set<String> permissAPIs = adminPermissions
                .stream().map(AdminPermission::getUrl).collect(Collectors.toSet());
        return permissAPIs;
    }
}
