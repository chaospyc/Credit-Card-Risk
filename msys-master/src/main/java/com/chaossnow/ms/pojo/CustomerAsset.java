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

}
