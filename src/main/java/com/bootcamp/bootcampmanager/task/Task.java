package com.bootcamp.bootcampmanager.task;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.filedb.FileDB;
import com.bootcamp.bootcampmanager.link.Link;
import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    @Column
    private boolean isCompleted;

    /*@Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_id", referencedColumnName = "id")
    private Link link;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private FileDB fileDB;

    @ManyToMany(mappedBy = "tasks")
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    private Bootcamp bootcamp;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;*/

    /*@OneToMany(mappedBy = "task")
    private List<Link> links;*/

    /*@OneToMany(mappedBy = "task")
    private List<FileDB> files;*/

    public Task(String name, String description, boolean isCompleted, Date deadline, FileDB fileDB) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
        this.deadline = deadline;
        this.fileDB = fileDB;
    }

    public String getStatus(boolean isCompleted) {
        String status = "";
        if(isCompleted) {
            status = "completed";
        } else {
            status = "not started";
        }
        return status;
    }
}
