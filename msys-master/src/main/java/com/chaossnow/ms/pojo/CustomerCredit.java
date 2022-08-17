package com.chaossnow.ms.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerCredit implements Serializable {

  private long id;
  private long customerId;
  private long grade;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  public long getGrade() {
    return grade;
  }

  public void setGrade(long grade) {
    this.grade = grade;
  }

}
