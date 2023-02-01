package com.example.spring_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.spring_boot.mapper")
public class MybatisplusDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisplusDemoApplication.class, args);
    }
}
