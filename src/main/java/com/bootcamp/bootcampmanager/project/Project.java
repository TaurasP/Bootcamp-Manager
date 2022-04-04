package com.bootcamp.bootcampmanager.project;

import com.bootcamp.bootcampmanager.group.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 100)
    private Date dateFrom;

    @Column(nullable = false, length = 100)
    private Date dateTo;

    @OneToOne(mappedBy = "project")
    private Group group;

}
