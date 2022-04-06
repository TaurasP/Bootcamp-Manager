package com.bootcamp.bootcampmanager.group;

import org.springframework.stereotype.Service;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void saveGroup(Group group);

    Group getGroupById(long id);
    void deleteGroupById(long id);
}
