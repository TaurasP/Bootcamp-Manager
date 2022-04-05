package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImp {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImp(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
