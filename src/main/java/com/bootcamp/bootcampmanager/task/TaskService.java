package com.bootcamp.bootcampmanager.task;

import java.util.List;

public interface TaskService {
    public List<Task> getTasksByCourse(long courseId);
}
