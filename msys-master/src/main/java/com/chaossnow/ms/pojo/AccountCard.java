package com.chaossnow.ms.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AccountCard implements Serializable {

  private long id;
  private long accountId;
  private long custmerId;
  private long quota;
  private long balance;
  private long overdueNum;
  private long enabled;
  private String accountBank;
  private java.sql.Timestamp date;

}
