package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.User;

import java.util.List;

/**
 * @author chaos
 * @ClassName UserDao
 * @date 2022年07月31日 0:18
 * @Version 1.0
 */
public interface UserDao {

    User findByUsername(String username);

    Integer getCount(String username,String password);

    void save(User user);

    List<User> listAllUsers();

    User findById(Integer id);

    void update(User user);

    User getByUsername(String username);
}
