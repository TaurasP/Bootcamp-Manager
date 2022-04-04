package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;
}
