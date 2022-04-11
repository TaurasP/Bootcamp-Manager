package com.bootcamp.bootcampmanager.mail;

import com.bootcamp.bootcampmanager.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MailThread extends Thread{

    private MailService mailService;
    private User user;

    public MailThread(MailService mailService, User user) {
        this.mailService = mailService;
        this.user = user;
    }

    @Override
    public void run() {
        try{
            mailService.sendEmailForNewUser(user);
        }
        catch(Exception e){
        }
    }
}
