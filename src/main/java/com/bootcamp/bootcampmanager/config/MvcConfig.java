package com.bootcamp.bootcampmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        /*registry.addViewController("/index").setViewName("index");*/
        registry.addViewController("/bootcamps").setViewName("bootcamps");
        registry.addViewController("/groups").setViewName("groups");
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/tasks").setViewName("tasks");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/students").setViewName("students");
        registry.addViewController("/profile").setViewName("profile");
    }
}