package com.example.j2eefinalv2.controller;

import com.example.j2eefinalv2.entity.Project;
import com.example.j2eefinalv2.service.ProjectService;
import com.example.j2eefinalv2.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    /**
     *  查询项目列表
     */
    @RequestMapping(value = "/projectFindAll")
    public String list(String title, String uploader, String role, String type,
                       String fund, Model model) {
        // 条件查询所有项目
        List<Project> projects = projectService.getProjectList(title, uploader, type, fund);
        model.addAttribute("projects",projects);
        if(Objects.equals(role, "管理员"))
            return "project";
        else
            return "studentProject";
    }
    @RequestMapping("/projectSetScore")
    public String projectSetScore(String title, int score){
        projectService.setScore(title, score);
        return "redirect:project";
    }
    //上传
    @RequestMapping("/projectUpload")
    public String handleFormUpload(Project project,@RequestParam("upload") List<MultipartFile> upload,
                                   HttpServletRequest request) {
        String f=null;
        // 判断所上传文件是否存在
        if (!upload.isEmpty() && upload.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : upload) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                f=file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                //String dirPath = request.getServletContext().getRealPath("/upload/");
                String dirPath = "C:\\Users\\12709\\Desktop\\j2eefinal-v2.2\\fileRecv\\Project\\";
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
                /*
                 * String newFilename = name+ "_"+UUID.randomUUID() + "_"+originalFilename;
                 */
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath+originalFilename));
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        //设置项目信息
        project.setAddress(f);
        projectService.addProject(project);
        if(Objects.equals(userService.getUserByName(project.getUploader()).getRole(), "管理员"))
            return "redirect:project";
        else
            return "redirect:studentProject";
    }



    //下载
    @RequestMapping("/projectDownload")
    public ResponseEntity<byte[]> fileDownload(String title, HttpServletRequest request, HttpSession session) throws Exception{

        Project p = projectService.searchProject(title);
        String filename = p.getAddress();
        System.out.println(filename);
        // 指定要下载的文件所在路径
        // String path = request.getServletContext().getRealPath("/upload/");
        String path = "C:\\Users\\12709\\Desktop\\j2eefinal-v2.2\\fileRecv\\Project";
        // 创建该文件对象
        File file = new File(path+File.separator+filename);
        // 对文件名编码，防止中文文件乱码
        filename = this.getFilename(request, filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", filename);
        // 定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 使用Spring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }






    public String getFilename(HttpServletRequest request,String filename) throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }
}
