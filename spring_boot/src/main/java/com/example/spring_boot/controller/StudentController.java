package com.example.spring_boot.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.spring_boot.entity.Student;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.mapper.StudentMapper;
import com.example.spring_boot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/show")
    public Result show() {

        List<Student> students = studentMapper.show();
        System.out.println(students);
        return Result.ok().data("data",students);
    }
    @PostMapping("/deleted/{id}")
    public Result deleted(@PathVariable Integer id) {

        studentMapper.deleted(id);
        return Result.ok();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Student student){
        studentMapper.update(student);
        return Result.ok();
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody Student student) {
        studentMapper.insert(student);
        return Result.ok();
    }
    @PostMapping("/selected")
    public Result select(@RequestBody JSONObject param){
        String content = param.getString("content");
        String select = param.getString("select");
        List<Student> students = null;
        System.out.println(select + "-->" + content);

        if (content.equals("phone")) {
            students = studentMapper.selectByphone(content);
        }else if (select.equals("name")){
            students = studentMapper.selectByname(content);
        }
        return Result.ok().data("data",students);
    }
}

