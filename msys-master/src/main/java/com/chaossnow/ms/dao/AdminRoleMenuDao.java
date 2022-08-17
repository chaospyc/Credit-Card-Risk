package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.AdminRoleMenu;

import java.util.List;

public interface AdminRoleMenuDao {

    List<AdminRoleMenu> listByRids(List<Long> rids);
}
