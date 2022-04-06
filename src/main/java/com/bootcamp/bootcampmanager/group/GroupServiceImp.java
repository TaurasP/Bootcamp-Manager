package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.group.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImp implements GroupService{

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImp(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    @Override
    public void saveGroup(Group group) {

        groupRepository.save(group);
    }

    @Override
    public Group getGroupById(long id) {
        return groupRepository.getById(id);
    }

    @Override
    public void deleteGroupById(long id) {
        groupRepository.deleteById(id);
    }
}
