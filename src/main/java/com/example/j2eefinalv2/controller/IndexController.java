package com.example.j2eefinalv2.controller;

import com.example.j2eefinalv2.entity.Paper;
import com.example.j2eefinalv2.entity.Project;
import com.example.j2eefinalv2.entity.User;
import com.example.j2eefinalv2.service.PaperService;
import com.example.j2eefinalv2.service.ProjectService;
import com.example.j2eefinalv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    /** 跳转到首页 */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/studentIndex")
    public String studentIndex(){return"studentIndex";}
    @Autowired
    PaperService paperService;
    @RequestMapping("/paper")
    public String paper(ModelMap modelMap) {
        List<Paper> papers = paperService.getPaperList(null,null);
        modelMap.addAttribute("papers",papers);
        // 添加参数
        return "paper";
    }
    @RequestMapping("/studentPaper")
    public String studentPaper(){
        return "studentPaper";}
    @Autowired
    UserService userService;
    @RequestMapping("/user")
    public String user(ModelMap modelMap){
        List<User> users = userService.getUserList(null, null);
        modelMap.addAttribute("users", users);
        return "user";
    }
    @Autowired
    ProjectService projectService;
    @RequestMapping("/project")
    public String project(ModelMap modelMap){
        List<Project> projects = projectService.getProjectList(null, null, null, null);
        modelMap.addAttribute("projects", projects);
        return "project";
    }
    @RequestMapping("/studentProject")
    public String studentProject(){return "studentProject";}
}
