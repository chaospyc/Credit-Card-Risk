package com.chaossnow.ms.shiro.service.impl;

import com.chaossnow.ms.dao.AdminRoleMenuDao;
import com.chaossnow.ms.pojo.AdminRoleMenu;
import com.chaossnow.ms.shiro.service.AdminRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ms-master
 * @description: 角色 菜单
 * @author: chaos
 * @create: 2022-08-15 14:10
 **/
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {

    @Autowired
    private AdminRoleMenuDao adminRoleMenuDao;

    @Override
    public List<AdminRoleMenu> listByRid(List<Long> rids) {

        return adminRoleMenuDao.listByRids(rids);
    }
}
