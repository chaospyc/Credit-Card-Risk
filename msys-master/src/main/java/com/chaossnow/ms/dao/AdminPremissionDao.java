package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.AdminPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface AdminPremissionDao {
    List<AdminPermission> listAllPermissions();


    List<AdminPermission> listPermissionsById(List<Long> pids);

    List<AdminPermission> listPermissionsByIds(@Param("tagIds")Set<Long> pids);
}
