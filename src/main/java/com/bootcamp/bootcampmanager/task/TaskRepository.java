package com.bootcamp.bootcampmanager.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /*List<Task> findByCourse_IdEquals(long id);*/

}
