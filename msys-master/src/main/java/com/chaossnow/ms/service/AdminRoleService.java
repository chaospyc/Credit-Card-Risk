package com.chaossnow.ms.service;

import com.chaossnow.ms.dto.RoleBean;
import com.chaossnow.ms.dto.RolePermission;
import com.chaossnow.ms.dto.UserRole;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.result.Result;

import java.util.Arrays;
import java.util.List;

public interface AdminRoleService {

    List<AdminRole> listRolesByUser(String username);
    List<AdminRole> listRolesByCurrUser();
    List<AdminRole> listRoles();

    AdminRole updateRoleStatus(AdminRole requestAdminRole);


    void editRole(RolePermission requestRolePermission);

    UserRole getRolesByUser(String username);


    Result addRole(RoleBean role);
}
