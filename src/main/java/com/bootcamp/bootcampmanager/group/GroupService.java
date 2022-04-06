package com.bootcamp.bootcampmanager.group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    void saveGroup(Group group);

    Group getGroupById(long id);
    void deleteGroupById(long id);
}
