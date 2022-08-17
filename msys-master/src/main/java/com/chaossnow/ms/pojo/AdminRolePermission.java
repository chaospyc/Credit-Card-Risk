package com.chaossnow.ms.pojo;


import java.io.Serializable;

public class AdminRolePermission implements Serializable {

  private long id;
  private long rid;
  private long pid;


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


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }

}
