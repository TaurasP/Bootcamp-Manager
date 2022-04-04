package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.project.Project;
import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 300)
    private String name;

    @OneToMany(mappedBy = "group") //targetEntity = Group.class, cascade = CascadeType.ALL, orphanRemoval = true
    private List<Student> students;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
    
}
