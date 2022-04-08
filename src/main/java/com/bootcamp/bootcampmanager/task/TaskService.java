package com.bootcamp.bootcampmanager.task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    void saveTask(Task task);
    Task getTaskById(long id);
    void deleteTaskById(long id);
    /*public List<Task> getTasksByCourse(long courseId);*/
}
