package com.bootcamp.bootcampmanager.controller;

import com.bootcamp.bootcampmanager.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;
}
