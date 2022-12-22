package com.example.j2eefinalv2.service;

import com.example.j2eefinalv2.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList(String username, String name);
    public void register(String username,String password, String role, String name);//注册
    public User getUser(String username);//查询

    public User getUserByName(String name);
    public User getUserLogin(String username, String password);
    public void deleteUser(String username);

}
