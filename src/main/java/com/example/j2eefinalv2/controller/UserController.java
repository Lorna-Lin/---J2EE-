package com.example.j2eefinalv2.controller;

import com.example.j2eefinalv2.entity.User;
import com.example.j2eefinalv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    public String getUserList(ModelMap modelMap){
        List<User> userList;
        userList = userService.getUserList(null, null);
        modelMap.addAttribute("userList",userList);
        return "user";
    }
    @RequestMapping("/searchUser")
    public String searchUser(String username, String name, ModelMap modelMap){
        List<User> userList;
        userList = userService.getUserList(username, name);
        modelMap.addAttribute("userList", userList);
        return "user";
    }
    @RequestMapping("deleteUser")
    public String deleteUser(String username){
        userService.deleteUser(username);
        return "user";
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String role, @RequestParam String name,
                          HttpServletRequest request){
        User user = userService.getUser(username);
        if(null != user){
            return "user";
        }
        else{
            request.setAttribute("msg", "注册成功");
            userService.register(username, password, role, name);
            return "user";
        }
    }
}
