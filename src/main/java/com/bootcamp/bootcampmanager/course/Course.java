package com.bootcamp.bootcampmanager.course;

import com.bootcamp.bootcampmanager.task.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private boolean IsCompleted;

    @OneToMany(mappedBy = "course")
    private List<Task> tasks;

}
