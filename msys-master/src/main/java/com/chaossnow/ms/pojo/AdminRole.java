package com.chaossnow.ms.pojo;


import com.chaossnow.ms.dto.RoleBean;
import lombok.Builder;

import java.io.Serializable;

@Builder
public class AdminRole implements Serializable {

  private long id;
  private String name;
  private String nameZh;
  private long enabled;


  public AdminRole() {

  }

  /**
   * 将dto类转为Role类，用户增加Role
   * @param role
   */
  public AdminRole(RoleBean role) {
        this.setName(role.getName());
        this.setEnabled(role.getEnabled());
        this.setNameZh(role.getNameZh());
  }
  public AdminRole(long id, String name, String nameZh, long enabled) {
    this.id = id;
    this.name = name;
    this.nameZh = nameZh;
    this.enabled = enabled;
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



  @Override
  public String toString() {
    return "AdminRole{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", nameZh='" + nameZh + '\'' +
            ", enabled=" + enabled +
            '}';
  }


}
