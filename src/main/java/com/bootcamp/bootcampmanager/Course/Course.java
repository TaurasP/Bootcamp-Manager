package com.bootcamp.bootcampmanager.Course;

import com.bootcamp.bootcampmanager.Task.Task;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    Date dateFrom;
    Date dateTo;
    boolean IsCompleted;
    @OneToMany(targetEntity = Task.class,mappedBy = "course")
    List<Task> tasks;

}
