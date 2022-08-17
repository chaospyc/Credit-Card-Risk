package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.AdminRolePermission;

import java.util.List;
import java.util.Set;

public interface AdminRolePermissionDao {
    List<Long> listPidsByRid(Long rid);

    List<AdminRolePermission> listByRid(Long rid);

    List<AdminRolePermission> listByRids(List<Long> rids);
}
