package com.chaossnow.ms.shiro.service;

import com.chaossnow.ms.pojo.AdminPermission;
import com.chaossnow.ms.pojo.AdminRole;

import java.util.List;
import java.util.Set;

public interface AdminRolePermissionService {

    List<AdminPermission> listPermissionsByRole(String rolename);

    List<AdminPermission> listPermissionsByRoles(List<AdminRole> adminRoles);
}
