package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.AdminMenuDao;
import com.chaossnow.ms.pojo.AdminMenu;
import com.chaossnow.ms.pojo.AdminRoleMenu;
import com.chaossnow.ms.pojo.AdminUserRole;
import com.chaossnow.ms.pojo.User;
import com.chaossnow.ms.service.AdminMenuService;
import com.chaossnow.ms.service.AdminRoleMenuService;
import com.chaossnow.ms.service.AdminUserRoleService;
import com.chaossnow.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: ms-master
 * @description: 用户菜单
 * @author: chaos
 * @create: 2022-08-15 13:11
 **/

@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminMenuDao adminMenuDao;
    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Autowired
    private AdminRoleMenuService adminRoleMenuService;

    @Override
    public List<AdminMenu> listByUsername() {
        User user = userService.getCurrentUser();
        List<Long> rids = adminUserRoleService.findByUid(user.getId())
                .stream()
                .map(AdminUserRole::getRid)
                .collect(Collectors.toList());
        List<Long> menuIds = adminRoleMenuService.listByRid(rids)
                .stream()
                .map(AdminRoleMenu::getMid)
                .collect(Collectors.toList());
        List<AdminMenu> adminMenus = listByIds(menuIds);
        return adminMenus;
    }

    private List<AdminMenu> listByIds(List<Long> menuIds) {
        return adminMenuDao.listByIds(menuIds);
    }

}
