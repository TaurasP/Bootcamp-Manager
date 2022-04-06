package com.bootcamp.bootcampmanager;

import com.bootcamp.bootcampmanager.user.User;
import com.bootcamp.bootcampmanager.user.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampManagerApplication.class, args);
    }
}
