package com.bootcamp.bootcampmanager.password;

import com.bootcamp.bootcampmanager.user.User;

public interface PasswordGeneratorService {
    void generateRandomPassword(User user);
}
