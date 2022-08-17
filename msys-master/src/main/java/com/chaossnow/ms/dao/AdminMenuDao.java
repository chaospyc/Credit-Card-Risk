package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.AdminMenu;

import java.util.List;

public interface AdminMenuDao {
    List<AdminMenu> listByIds(List<Long> ids);
}
