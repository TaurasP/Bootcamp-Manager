package com.bootcamp.bootcampmanager.password;

import com.bootcamp.bootcampmanager.user.User;
import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService{

    public void generateRandomPassword(User user) {
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String password = passwordGenerator.generate(8);
        user.setPassword(password);
    }
}
