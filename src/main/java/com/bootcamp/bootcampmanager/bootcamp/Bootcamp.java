package com.bootcamp.bootcampmanager.bootcamp;


import com.bootcamp.bootcampmanager.admin.Admin;
import com.bootcamp.bootcampmanager.course.Course;
import com.bootcamp.bootcampmanager.lecturer.Lecturer;
import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bootcamps")
@Getter
@Setter
@NoArgsConstructor
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date dateFrom;

    @Column(nullable = false)
    private Date dateTo;

    @OneToMany(mappedBy = "bootcamp")
    private List<Student> students;

    @ManyToMany(mappedBy = "bootCamps")
    List<Course> coursesInCamp;


    @ManyToMany(mappedBy = "joinedBootcamp")
    List<Lecturer> campLecturers;

    @ManyToMany(mappedBy = "managingBootcamp")
    List<Admin> adminList;

}
