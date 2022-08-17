package com.chaossnow.ms.dto;

import com.chaossnow.ms.dto.impl.OutputConverter;
import com.chaossnow.ms.pojo.AdminPermission;

import java.util.List;

/**
 * @program: ms-master
 * @description: 角色与权限实体
 * @author: chaos
 * @create: 2022-08-13 22:37
 **/
public class RolePermission implements OutputConverter {
    private long id;
    private String name;
    private String nameZh;
    private long enabled;
    private List<AdminPermission> adminPermissions;

    public RolePermission() {
    }

    public RolePermission(long id, String name, String nameZh, long enabled, List<AdminPermission> adminPermissions) {
        this.id = id;
        this.name = name;
        this.nameZh = nameZh;
        this.enabled = enabled;
        this.adminPermissions = adminPermissions;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", enabled=" + enabled +
                ", adminPermissions=" + adminPermissions +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public long getEnabled() {
        return enabled;
    }

    public void setEnabled(long enabled) {
        this.enabled = enabled;
    }

    public List<AdminPermission> getAdminPermissions() {
        return adminPermissions;
    }

    public void setAdminPermissions(List<AdminPermission> adminPermissions) {
        this.adminPermissions = adminPermissions;
    }
}
