package com.chaossnow.ms.pojo;

import java.io.Serializable;

public class AdminRoleMenu implements Serializable {

  private long id;
  private long rid;
  private long mid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRid() {
    return rid;
  }

  public void setRid(long rid) {
    this.rid = rid;
  }


  public long getMid() {
    return mid;
  }

  public void setMid(long mid) {
    this.mid = mid;
  }


  public AdminRoleMenu() {
  }

  public AdminRoleMenu(long id, long rid, long mid) {
    this.id = id;
    this.rid = rid;
    this.mid = mid;
  }

  @Override
  public String toString() {
    return "AdminRoleMenu{" +
            "id=" + id +
            ", rid=" + rid +
            ", mid=" + mid +
            '}';
  }
}
