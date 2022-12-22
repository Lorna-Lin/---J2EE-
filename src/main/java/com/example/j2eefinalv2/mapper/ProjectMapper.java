package com.example.j2eefinalv2.mapper;

import com.example.j2eefinalv2.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

    public List<Project> getProjectList(String title, String uploader, String type, String fund);//查询所有符合条件的项目信息
    public void setScore(String title, int score);
    public Project getProject(String title);//查询项目信息

    public void addProject(Project project);//上传项目
}