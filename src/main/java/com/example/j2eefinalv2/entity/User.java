package com.example.j2eefinalv2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@TableName("User")
@Data
public class User {
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("role")
    private String role;
    @TableField("name")
    private String name;
}
