package com.bootcamp.bootcampmanager.config.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class Encoder {

    public static BCryptPasswordEncoder get() {

        BCryptPasswordEncoder.BCryptVersion version = BCryptPasswordEncoder.BCryptVersion.$2Y;
        int strength = 4;
        SecureRandom random = new SecureRandom();
        byte salt[] = new byte[8];
        random.nextBytes(salt);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(version, strength, random);
        return encoder;
    }

}
