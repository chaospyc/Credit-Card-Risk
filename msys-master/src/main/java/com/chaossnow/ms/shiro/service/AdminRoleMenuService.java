package com.chaossnow.ms.shiro.service;

import com.chaossnow.ms.pojo.AdminRoleMenu;

import java.util.List;

public interface AdminRoleMenuService {
    List<AdminRoleMenu> listByRid(List<Long> rids);
}
