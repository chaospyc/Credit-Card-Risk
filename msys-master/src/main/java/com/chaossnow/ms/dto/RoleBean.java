package com.chaossnow.ms.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: ms-master
 * @description: 增加角色的Bean
 * @author: chaos
 * @create: 2022-08-14 22:50
 **/

@Data
public class RoleBean {

    @NotEmpty(message = "用户名不能为空")
    private String name;

    private String nameZh;

    private long enabled;

}
