package com.chaossnow.ms.service;

import com.chaossnow.ms.pojo.AdminMenu;

import java.util.List;

public interface AdminMenuService {
    List<AdminMenu> listByUsername();
}
