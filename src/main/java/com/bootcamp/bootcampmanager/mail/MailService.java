package com.bootcamp.bootcampmanager.mail;

import com.bootcamp.bootcampmanager.user.User;

public interface MailService {
    void sendEmail(Mail mail);
    void sendEmailForNewUser(User user);
}
