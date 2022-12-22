package com.example.j2eefinalv2.service;

import com.example.j2eefinalv2.entity.Project;

import java.util.List;

public interface ProjectService {
    public Project searchProject(String title);
    public void setScore(String title, int score);
    public List<Project> getProjectList(String title, String uploader, String type, String fund);

    public void addProject(Project project);
}
