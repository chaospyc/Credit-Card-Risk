package com.chaossnow.ms.service;

import com.chaossnow.ms.dto.UserDTO;
import com.chaossnow.ms.pojo.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void resetPassword(User user);

    User findByUsername(String username);

    Integer getCount(String username, String password);

    Set<String> getRolesByUserName(String username);

    Set<String> getPermissionsByUserName(String username);

    User getUserByName(String username);

    int register(User user);

    List<UserDTO> listAllUsers();

    UserDTO editUser(UserDTO UserDTO);


    void updateUserStatus(User user);

    User getCurrentUser();
}
