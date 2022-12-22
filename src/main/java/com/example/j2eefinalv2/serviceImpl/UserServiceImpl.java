package com.example.j2eefinalv2.serviceImpl;

import com.example.j2eefinalv2.entity.User;
import com.example.j2eefinalv2.mapper.UserMapper;
import com.example.j2eefinalv2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUserList(String username, String name) {
        return userMapper.getUserList(username, name);
    }

    @Override
    public void register(String username, String password,
                         String role, String name) {
        userMapper.register(username, password, role, name);
    }

    @Override
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
    @Override
    public User getUserLogin(String username, String password){
        return userMapper.getUserLogin(username, password);
    }
    @Override
    public void deleteUser(String username){userMapper.deleteUser(username);}

    public User getUserByName(String name){return userMapper.getUserByName(name);}
}
