package com.example.spring_boot.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.spring_boot.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {
    @Select("select password from user where username=#{username}")
    public String login(String username);

    @Update("update user set password=#{password} where username=#{username}")
    public Integer update(JSONObject param);
}
