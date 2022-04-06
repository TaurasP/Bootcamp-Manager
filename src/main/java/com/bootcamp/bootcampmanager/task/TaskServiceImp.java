package com.bootcamp.bootcampmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    public TaskRepository taskRepository;
}
