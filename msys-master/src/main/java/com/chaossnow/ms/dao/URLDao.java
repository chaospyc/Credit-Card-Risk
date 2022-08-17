package com.chaossnow.ms.dao;

import java.util.Set;

public interface URLDao {

    Set<String> listRolesByUser(String username);
}
