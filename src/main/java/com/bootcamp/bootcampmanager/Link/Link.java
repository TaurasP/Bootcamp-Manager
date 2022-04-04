package com.bootcamp.bootcampmanager.Link;

import com.bootcamp.bootcampmanager.Course.Course;
import com.bootcamp.bootcampmanager.Task.Task;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @ManyToOne
    @JoinColumn(name="task_id",nullable = false)
    private Task task;
    String url;
}
