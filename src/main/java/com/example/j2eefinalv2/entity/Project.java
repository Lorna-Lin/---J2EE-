package com.example.j2eefinalv2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;



@Component
@TableName("project")
@Data
public class Project {
    @TableField("title")
    private String title;
    @TableField("fund")
    private String fund;
    @TableField("uploader")
    private String uploader;
    @TableField("type")
    private String type;
    @TableField("address")
    private String address;
    @TableField("score")
    private Integer score;
}
