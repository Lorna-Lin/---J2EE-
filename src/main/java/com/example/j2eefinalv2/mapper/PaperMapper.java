package com.example.j2eefinalv2.mapper;

import com.example.j2eefinalv2.entity.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {

    public List<Paper> getPaperList(String title, String uploader);//查询所有符合条件的论文信息

    public void setScore(String title, int score);
    public Paper getPaper(String title);//查询论文信息

    public void addPaper(Paper paper);//上传论文
}
