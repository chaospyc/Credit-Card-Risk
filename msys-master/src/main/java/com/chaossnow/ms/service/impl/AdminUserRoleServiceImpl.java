package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.AdminUserRoleDao;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.pojo.AdminUserRole;
import com.chaossnow.ms.service.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {

    @Autowired
    private AdminUserRoleDao adminUserRoleDao;

    @Override
    public List<AdminUserRole> findByUid(Long uid) {
        List<AdminUserRole> adminUserRoles = adminUserRoleDao.findByUid(uid);
        return adminUserRoles;
    }

    @Override
    @Transactional
    public void updateRoleChanges(long uid, List<AdminRole> roles) {
        //删除原有的用户角色
        //存储新的的用户角色关系
        adminUserRoleDao.deleteAllByUid(uid);
    }
}
