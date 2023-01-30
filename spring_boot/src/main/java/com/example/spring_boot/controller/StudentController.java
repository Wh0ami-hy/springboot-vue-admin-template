package com.example.spring_boot.controller;


import com.example.spring_boot.entity.Student;
import com.example.spring_boot.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/show")
    public Result show() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("王" + i);
            student.setId("" + i);
            student.setPhone("8555" + i);
            student.setClasses("46" + i);
            students.add(student);
        }
        return Result.ok().data("data",students);
    }

    @PostMapping("/delete")
    public List<Student> delete() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setName("王" + i);
            student.setId("" + i);
            student.setPhone("8555" + i);
            student.setClasses("46" + i);
            students.add(student);
        }
        return students;
    }
    @PostMapping("/edit")
    public List<Student> edit() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setName("王" + i);
            student.setId("" + i);
            student.setPhone("8555" + i);
            student.setClasses("46" + i);
            students.add(student);
        }
        return students;
    }
}

