package com.example.spring_boot.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.core.annotation.Order;

import java.util.List;

@TableName("user")  //告诉MybatisPlus 要操作的表名（当类名和表名不一致时可用）
public class User {
    private String username = "admin";
    private String password = "admin";
    private String id = "1";

    //描述用户所有订单
    @TableField(exist = false)
    private List<Order> orders; //要对order字段做映射

    //右键generate，选择，setter、getter，生成get和set方法

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
