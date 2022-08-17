package com.chaossnow.ms.pojo;


import lombok.Data;

import java.io.Serializable;


@Data
public class CustomerAsset implements Serializable {

  private long id;
  private long customerId;
  private long fixAsset;
  private long deposit;
  private long securities;
  private long annualIncome;


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


  public long getFixAsset() {
    return fixAsset;
  }

  public void setFixAsset(long fixAsset) {
    this.fixAsset = fixAsset;
  }


  public long getDeposit() {
    return deposit;
  }

  public void setDeposit(long deposit) {
    this.deposit = deposit;
  }


  public long getSecurities() {
    return securities;
  }

  public void setSecurities(long securities) {
    this.securities = securities;
  }


  public long getAnnualIncome() {
    return annualIncome;
  }

  public void setAnnualIncome(long annualIncome) {
    this.annualIncome = annualIncome;
  }

}
