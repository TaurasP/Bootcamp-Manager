package com.bootcamp.bootcampmanager.service;

import com.bootcamp.bootcampmanager.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImp {

    @Autowired
    public GroupRepository groupRepository;

}
