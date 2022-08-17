package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.result.Result;

import java.util.List;

public interface AdminRoleDao {
    List<Integer> listRolesByUser(String username);

    List<AdminRole> findAllById(List<Long> rids);

    List<AdminRole> listRoles();

    AdminRole getByName(String name);

    void updateRoleStatus(AdminRole adminRole);

    void update(AdminRole adminRole);

    Result insertRole(AdminRole requestRole) throws Exception;
}
