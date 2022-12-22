package com.example.j2eefinalv2.serviceImpl;

import com.example.j2eefinalv2.entity.Project;
import com.example.j2eefinalv2.mapper.ProjectMapper;
import com.example.j2eefinalv2.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectmapper;

    @Override
    public Project searchProject(String title) {
        return projectmapper.getProject(title);
    }
    @Override
    public void setScore(String title, int score){
        projectmapper.setScore(title, score);
    }
    @Override
    public List<Project> getProjectList(String title, String uploader, String type, String fund) {

        return projectmapper.getProjectList(title, uploader, type, fund);
    }
    public void addProject(Project project) {
        projectmapper.addProject(project);
    }
}
