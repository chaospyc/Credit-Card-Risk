package com.chaossnow.ms.shiro.service;

import com.chaossnow.ms.pojo.AdminPermission;
import com.chaossnow.ms.pojo.AdminRole;

import java.util.List;
import java.util.Set;

public interface AdminPermissionService {

    List<AdminPermission> listAllPermissions();

    boolean needFilter(String requestAPI);

    Set<String> listPermissionURLsByUser(String username);

    Set<String> listPermissionURLsByRoles(List<AdminRole> adminRoles);
}
