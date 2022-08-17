package com.chaossnow.ms.shiro.service;

import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.pojo.AdminUserRole;

import java.util.List;

public interface AdminUserRoleService {
    List<AdminUserRole> findByUid(Long uid);

    void updateRoleChanges(long uid, List<AdminRole> roles);

}
