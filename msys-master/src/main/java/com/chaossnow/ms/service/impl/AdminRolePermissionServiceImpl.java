package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.AdminPremissionDao;
import com.chaossnow.ms.dao.AdminRoleDao;
import com.chaossnow.ms.dao.AdminRolePermissionDao;
import com.chaossnow.ms.pojo.AdminPermission;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.pojo.AdminRolePermission;
import com.chaossnow.ms.service.AdminRolePermissionService;
import com.chaossnow.ms.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program: ms-master
 * @description: 角色权限关系的实现比表
 * @author: chaos
 * @create: 2022-08-14 00:06
 **/

@Service
public class AdminRolePermissionServiceImpl implements AdminRolePermissionService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Autowired
    private AdminRolePermissionDao adminRolePermissionDao;

    @Autowired
    private AdminPremissionDao adminPremissionDao;

    @Override
    public List<AdminPermission> listPermissionsByRole(String rolename) {
        Long rid = adminRoleDao.getByName(rolename).getId();
        // List<Long> pids = adminRolePermissionDao.listPidsByRid(rid);
        List<Long> pids = adminRolePermissionDao.listByRid(rid)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        List<AdminPermission> adminPermissions = adminPremissionDao.listPermissionsById(pids);
        return adminPermissions;
    }

    @Override
    public List<AdminPermission> listPermissionsByRoles(List<AdminRole> adminRoles) {
        List<Long> rids = adminRoles.stream().map(AdminRole::getId).collect(Collectors.toList());
        List<AdminRolePermission> adminRolePermissions =  adminRolePermissionDao.listByRids(rids);
        Set<Long> pids = adminRolePermissions.stream().map(AdminRolePermission::getPid).collect(Collectors.toSet());
        List<AdminPermission> adminPermissions = adminPremissionDao.listPermissionsByIds(pids);
        return adminPermissions;
    }
}
