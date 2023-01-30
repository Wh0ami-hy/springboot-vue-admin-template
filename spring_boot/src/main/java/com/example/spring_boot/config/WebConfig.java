package com.example.spring_boot.config;

import com.example.spring_boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        //拦截/user/**路径的请求
        registry.addInterceptor( new LoginInterceptor()).addPathPatterns ("/demo/**");
    }
}

