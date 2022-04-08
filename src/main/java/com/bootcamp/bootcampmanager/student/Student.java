package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.task.Task;

import com.bootcamp.bootcampmanager.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private boolean enabled;

    @Column
    private String roles;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    private Bootcamp bootcamp;

    @ManyToMany
    @JoinTable(
            name = "student_tasks",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    List<Task> tasks;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;*/

    public Student(User user){
        super();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.roles;
        this.id = user.getId();
        this.enabled = true;
    }

    public Student(){
        super();
        this.roles = "ROLE_STUDENT";
    }

    public String userRole() {
        return "student";
    }

}
