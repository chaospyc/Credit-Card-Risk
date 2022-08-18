package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.UserDao;
import com.chaossnow.ms.dto.UserDTO;
import com.chaossnow.ms.pojo.AdminRole;
import com.chaossnow.ms.pojo.User;
import com.chaossnow.ms.service.AdminRoleService;
import com.chaossnow.ms.service.AdminUserRoleService;
import com.chaossnow.ms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chaos
 * @ClassName UserServiceImpl
 * @date 2022年07月31日 0:15
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public User getCurrentUser() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return getUserByName(username);
    }

    @Override
    public Integer getCount(String username,String password) {
        return userDao.getCount(username,password);
    }

    @Override
    public Set<String> getRolesByUserName(String username) {
        return null;
    }

    @Override
    public Set<String> getPermissionsByUserName(String username) {
        return null;
    }

    @Override
    public User getUserByName(String username) {
        User user = userDao.getByUsername(username);
        return user;
    }


    public boolean isExist(String username){
        User user = userDao.findByUsername(username);
        return null != user;
    }
    @Override
    @Transactional
    public int register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        String email = user.getEmail();
        //角色的姓名
        String name = user.getName();

        //进行转义 避免特殊字符引起的报错
        username = HtmlUtils.htmlEscape(username);
        user.setName(username);
        password = HtmlUtils.htmlEscape(password);
        user.setPassword(password);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        user.setEnabled(true);

        if(username.equals("") || password.equals("")){
            // 账号或者密码不能为空
            return 0;
        }

        boolean exist = isExist(username);

        if(exist){
            //账户已存在
            return 2;
        }

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5",password,salt,times).toString();

        user.setSalt(salt);
        user.setPassword(password);
        userDao.save(user);
        //用户创建成功
        return 1;
    }


    @Override
    @Transactional
    public List<UserDTO> listAllUsers() {
        List<User> userList = userDao.listAllUsers();
        List<UserDTO> userDTOS = userList
                .stream()
                .map(user -> (UserDTO) new UserDTO().convertFrom(user))
                .collect(Collectors.toList());
        userDTOS.forEach(u -> {
            List<AdminRole> adminRoles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(adminRoles);
        });
        return userDTOS;
    }


    @Override
    @Transactional
    public void resetPassword(User user) {
        // 先拿到旧的用户信息
        User userInDB = userDao.findByUsername(user.getUsername());
        // 更新用户的salt
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 更新用户的密码
        int times =2;
        String encodePassword = new SimpleHash("md5",user.getPassword(),salt,times).toString();
        userInDB.setPassword(encodePassword);
        userInDB.setSalt(salt);
        userDao.update(userInDB);
    }


    @Override
    @Transactional
    public UserDTO editUser(UserDTO userDTO) {
        User userInDB = userDao.findByUsername(userDTO.getUsername());
        userInDB.setName(userDTO.getName());
        userInDB.setEmail(userDTO.getEmail());
        userInDB.setPhone(userDTO.getEmail());
        adminUserRoleService.updateRoleChanges(userDTO.getId(),userDTO.getRoles());
        userDao.update(userInDB);
        return null;
    }


    @Override
    @Transactional
    public void updateUserStatus(User user) {
        User userInDB = userDao.findByUsername(user.getUsername());
        userInDB.setEnabled(user.isEnabled());
        userDao.update(userInDB);
    }
}
