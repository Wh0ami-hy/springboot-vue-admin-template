package com.example.spring_boot.mapper;

import com.example.spring_boot.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Mapper
public interface StudentMapper {
    //select 返回的是一个列表
    @Select("select * from student")
    public List<Student> show();

    @Update("update student set name=#{name},classes=#{classes},phone=#{phone} where id=#{id}")
    public Integer update(Student student);

    @Delete("delete from student where id=#{id}")
    public Integer deleted(Integer id);

    @Insert("insert into student values (#{id},#{name},#{classes},#{phone})")
    public Integer insert(Student student);

    @Select("select * from student where name=#{name}")
    public List<Student> selectByname(String name);

    @Select("select * from student where phone=#{phone}")
    public List<Student> selectByphone(String phone);


}
