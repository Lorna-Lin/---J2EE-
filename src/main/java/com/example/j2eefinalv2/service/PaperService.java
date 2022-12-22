package com.example.j2eefinalv2.service;

import com.example.j2eefinalv2.entity.Paper;

import java.util.List;

public interface PaperService {

    public Paper searchPaper(String title);
    public void setScore(String title, int score);
    public List<Paper> getPaperList(String title,String uploader);

    public void addPaper(Paper paper);
}
