package com.example.spring_boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String up(String name, MultipartFile photo, HttpServletRequest request) throws IOException{
        System.out.println(name);
        //获取文件名
        System.out.println(photo.getOriginalFilename());
        //取文件类型
        System.out.println(photo.getContentType());

        String path = request.getServletContext().getRealPath("/upload/");

        System.out.println(path);

        return "上传成功";

    }
    //保存上传文件至服务器
    public void saveFile(MultipartFile photo,String path) throws IOException{
        //判断路径是否存在
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
        System.out.println(file);
    }
}
