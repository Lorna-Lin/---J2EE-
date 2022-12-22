# 项目论文管理平台——J2EE期末项目

作为期末项目完成的项目论文管理平台，一个层次清楚结构简单的springboot项目，可以注册以及登录账号并在平台上完成对个人或所管理成员、项目和论文的增加、删除、查找、修改以及审核。

## 演示
![Show-Gif](https://github.com/Lorna-Lin/---J2EE-/blob/main/J2ee.gif)


## 特点

* Springboot项目
* 层次简单明了，易于使用
* 设有拦截器防止绕过登录访问
* 支持附件上传和下载，自动生成url
* 快捷退出登录

## 一、安装

需要一台拥有集成开发环境的机器，配备数据库。
解压该文件后需要根据你的电脑的端口号，数据库配置对项目的application.yml文件进行修改以下片段。
```yml
datasource:
    driver-class-name: com.mysql.jdbc.Driver或输入相应driver
    url: jdbc:mysql://localhost:3306/projectmanagement?useUnicode=true&characterEncoding=utf-8&useSSL=false即你自己的数据库url
    username: 你的数据库账号
    password: ******
```
在你的电脑上设置一个文件夹用于下载上传文件，复制其目录用于修改project和paper的controller中的文件路径。

```java
// 指定要下载的文件所在路径
    // String path = request.getServletContext().getRealPath("/upload/");
        String path = "X:\\sophomore1\\J2EE\\upload";
    //将此处改为你设置的文件夹路径
```
## 二、快速开始

如果你使用的是类似Intellij Idea这样的IDE，对于springboot项目可以在右上角一键启动。


## 自定义css

可以对css文件进行修改，将本平台中各个组件的格式修改成你喜欢的样式~


## Contributor

@高名竹 10205101515

@林如越 10215101566

@王盛阳 10215101508

已上传在github https://github.com/Lorna-Lin/---J2EE-.git
## 
