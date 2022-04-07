package com.bootcamp.bootcampmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    public TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByCourse(long courseId) {
        return taskRepository.findByCourse_IdEquals(courseId);
    }
}
