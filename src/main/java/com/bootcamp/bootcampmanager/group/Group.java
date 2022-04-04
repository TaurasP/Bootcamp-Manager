package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.project.Project;
import com.bootcamp.bootcampmanager.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 300)
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "group_project",
            joinColumns =
                    { @JoinColumn(name = "group_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "project_id", referencedColumnName = "id") })
    private Project project;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
