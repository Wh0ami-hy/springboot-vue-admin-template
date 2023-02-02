package com.example.spring_boot.controller;

import com.example.spring_boot.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping("/picture")
    public Result picture(MultipartFile photo) throws IOException{
        //获取文件名
        System.out.println(photo.getOriginalFilename());
        //取文件类型
        System.out.println(photo.getContentType());

        //获取web服务器运行路径
        //String path = request.getServletContext().getRealPath("/upload/");
        String path = "C:\\Users\\Hou_Yi\\Desktop\\springboot-vue-admin-template\\spring_boot\\src\\main\\resources\\static";
        System.out.println(path);
        saveFile(photo,path);
        return Result.ok();

    }
    //保存上传文件至服务器
    public void saveFile(MultipartFile photo,String path) throws IOException{
        File file = new File(path+ "\\"+ photo.getOriginalFilename());
        photo.transferTo(file);
        System.out.println(file);
    }
}
