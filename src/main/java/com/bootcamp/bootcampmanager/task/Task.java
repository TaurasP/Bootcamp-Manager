package com.bootcamp.bootcampmanager.task;

import com.bootcamp.bootcampmanager.course.Course;
import com.bootcamp.bootcampmanager.link.Link;
import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private boolean isCompleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "task")
    private List<Link> links;

    @ManyToMany(mappedBy = "tasks")
    List<Student> students;
}
