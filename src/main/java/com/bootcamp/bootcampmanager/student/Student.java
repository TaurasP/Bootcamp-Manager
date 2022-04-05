package com.bootcamp.bootcampmanager.student;


import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.group.Group;
import com.bootcamp.bootcampmanager.task.Task;

import com.bootcamp.bootcampmanager.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    private Bootcamp bootcamp;

    @ManyToMany
    @JoinTable(
            name = "student_task",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    List<Task> tasks;
}
