package com.chaossnow.ms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: bankcard-master
 * @description: 消费者注册视图类
 * @author: chaos
 * @create: 2022-08-17 23:27
 **/

@Data
public class CustomerVO implements Serializable {

    private long id;
    private String name;
    private long sex;
    private String idCard;
    private java.sql.Timestamp dateBirth;
    private String address;
    private String phone;
    private long marry;
    private long maxDegree;
}
