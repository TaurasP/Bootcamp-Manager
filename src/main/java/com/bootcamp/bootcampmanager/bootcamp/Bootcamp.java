package com.bootcamp.bootcampmanager.bootcamp;


import com.bootcamp.bootcampmanager.admin.Admin;
import com.bootcamp.bootcampmanager.course.Course;
import com.bootcamp.bootcampmanager.lecturer.Lecturer;
import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bootcamps")

public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
//            (nullable = false)
    private String name;

    @Column
//            (nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;

    @Column
//            (nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;

    @OneToMany(mappedBy = "bootcamp")
    private List<Student> students;

    @ManyToMany(mappedBy = "bootCamps")
    List<Course> coursesInCamp;


    @ManyToMany(mappedBy = "joinedBootcamp")
    List<Lecturer> campLecturers;

    @ManyToMany(mappedBy = "managingBootcamp")
    List<Admin> adminList;

    public Bootcamp() {
    }

    public Bootcamp(String name, Date dateFrom, Date dateTo) {
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Bootcamp(String name, Date dateFrom) {
        this.name = name;
        this.dateFrom = dateFrom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCoursesInCamp() {
        return coursesInCamp;
    }

    public void setCoursesInCamp(List<Course> coursesInCamp) {
        this.coursesInCamp = coursesInCamp;
    }

    public List<Lecturer> getCampLecturers() {
        return campLecturers;
    }

    public void setCampLecturers(List<Lecturer> campLecturers) {
        this.campLecturers = campLecturers;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }
}
