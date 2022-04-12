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
        registry.addViewController("/bootcamps").setViewName("bootcamps");
        registry.addViewController("/bootcamp").setViewName("bootcamp");
        registry.addViewController("/tasks").setViewName("tasks");
        registry.addViewController("/task").setViewName("task");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/students").setViewName("students");
        registry.addViewController("/student").setViewName("student");
        registry.addViewController("/student-homepage").setViewName("student-homepage");
        // registry.addViewController("/groups").setViewName("groups");
        // registry.addViewController("/group").setViewName("group");
        // registry.addViewController("/courses").setViewName("courses");
        // registry.addViewController("/course").setViewName("course");
    }
}