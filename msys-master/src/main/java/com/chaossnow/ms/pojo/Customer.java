package com.chaossnow.ms.pojo;


import lombok.Data;

import java.io.Serializable;


@Data
public class Customer implements Serializable {

  private long id;
  private String name;
  private long sex;
  private String idCard;
  private java.sql.Timestamp dateBirth;
  private String address;
  private String phone;


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


  public long getSex() {
    return sex;
  }

  public void setSex(long sex) {
    this.sex = sex;
  }


  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }


  public java.sql.Timestamp getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(java.sql.Timestamp dateBirth) {
    this.dateBirth = dateBirth;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


}
