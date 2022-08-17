package com.chaossnow.ms.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AccountLoan implements Serializable {

  private long id;
  private long accountId;
  private long loanSum;
  private long newBalance;
  private java.sql.Timestamp loanTime;
  private long repBalance;
  private java.sql.Timestamp repTime;
  private String repState;
  private long overState;
  private String accountType;

}
