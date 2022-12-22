package com.example.j2eefinalv2.controller;

import com.example.j2eefinalv2.entity.User;
import com.example.j2eefinalv2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Resource
    private UserService service;
    public void setService(UserService service) {
        this.service = service;
    }
    public UserService getService() {
        return service;
    }


    /**跳转到注册页面*/
    @RequestMapping(value="/register",method= RequestMethod.GET)
    public String index() {
        return "register";
    }

    /**用户注册*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String name, @RequestParam String password_rp, HttpServletRequest request) {
        User user = service.getUser(username);
        if(null!=user) {
            request.setAttribute("msg", "用户名已存在");
            return "register";
        }
        //确认密码
        else if(!password_rp.equals(password)){
            request.setAttribute("msg", "输入密码不一致！");
            return "register";
        }
        else {
            service.register(username, password, "普通用户", name);
            request.setAttribute("msg", "注册成功");
            return "register";
        }
    }


}
