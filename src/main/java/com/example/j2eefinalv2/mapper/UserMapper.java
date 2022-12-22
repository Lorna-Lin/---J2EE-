package com.example.j2eefinalv2.mapper;

import com.example.j2eefinalv2.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //登录
    public List<User> getUserList(String username, String name);

    //查询用户
    public User getUser(String username);
    public User getUserByName(String name);
    public User getUserLogin(String username, String password);
    //删除用户
    public void deleteUser(String username);
    //注册
    public void register(String username,String password, String role, String name);
}
