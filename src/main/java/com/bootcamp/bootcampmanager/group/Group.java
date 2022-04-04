package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.project.Project;
import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Groups")
@Getter
@Setter
@NoArgsConstructor
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
    
}
