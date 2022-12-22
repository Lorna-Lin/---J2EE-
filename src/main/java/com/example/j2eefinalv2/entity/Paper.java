package com.example.j2eefinalv2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@TableName("Paper")
@Data                      //可以省去set/get/toString等方法
public class Paper {
    @TableField(value = "title")
    private String title;
    @TableField(value = "uploader")
    private String uploader;
    @TableField(value = "address")
    private String address;    //本机存储位置
    @TableField(value = "score")
    private Integer score;


}
