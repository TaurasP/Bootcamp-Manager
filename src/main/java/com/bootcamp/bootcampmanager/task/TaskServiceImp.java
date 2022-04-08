package com.bootcamp.bootcampmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    public TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        Optional<Task> optional = taskRepository.findById(id);
        Task task;
        if (optional.isPresent()) {
            task = optional.get();
        } else {
            throw new RuntimeException("Not found task: " + id);
        }
        return task;
    }

    @Override
    public void deleteTaskById(long id) {
        this.taskRepository.deleteById(id);
    }

    /*@Override
    public List<Task> getTasksByCourse(long courseId) {
        return taskRepository.findByCourse_IdEquals(courseId);
    }*/
}
