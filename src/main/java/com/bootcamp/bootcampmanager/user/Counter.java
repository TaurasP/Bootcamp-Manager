package com.bootcamp.bootcampmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Counter {

    @Autowired
    static int a = 0;


    public int getIndex(){
        a++;
        return a;
    }
}
