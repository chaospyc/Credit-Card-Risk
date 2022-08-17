package com.chaossnow.ms.dao;


import com.chaossnow.ms.pojo.AdminUserRole;

import java.util.List;

public interface AdminUserRoleDao {
    List<AdminUserRole> findByUid(Long uid);

    void deleteAllByUid(long uid);
}
