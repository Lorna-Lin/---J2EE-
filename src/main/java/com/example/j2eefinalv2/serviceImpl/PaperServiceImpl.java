package com.example.j2eefinalv2.serviceImpl;

import com.example.j2eefinalv2.entity.Paper;
import com.example.j2eefinalv2.mapper.PaperMapper;
import com.example.j2eefinalv2.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper papermapper;

    @Override
    public Paper searchPaper(String title) {
        return papermapper.getPaper(title);
    }
    @Override
    public void setScore(String title, int score){
        papermapper.setScore(title, score);
    }
    @Override
    public List<Paper> getPaperList(String title,String uploader) {
        return papermapper.getPaperList(title, uploader);
    }
    public void addPaper(Paper paper) {
        papermapper.addPaper(paper);
    }
}
