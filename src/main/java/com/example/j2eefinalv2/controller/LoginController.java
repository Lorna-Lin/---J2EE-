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
import java.util.Objects;

@Controller
public class LoginController {
    @Resource
    private UserService service;
    public void setService(UserService service) {
        this.service = service;
    }
    /**跳转到登录界面*/
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login() {
        return "login";
    }
    /**用户登录*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpServletRequest request, HttpSession session) {
        User user = service.getUserLogin(username, password);
        if(null!=user) {
            session.setAttribute("user", user);
            if(Objects.equals(user.getRole(), "管理员"))
                return "redirect:index";
            else
                return "redirect:studentIndex";
        }else {
            request.setAttribute("msg", "用户名或密码不正确");
            return "login";
        }
    }

    /**退出登录*/
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpSession session) {
        request.setAttribute("msg", "退出成功");
        session.invalidate();
        return "login";
    }
}
