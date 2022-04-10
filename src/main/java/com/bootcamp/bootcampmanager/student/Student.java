package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.lecturer.Lecturer;
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

    @Column
    @Lob
    private String completedTasks;

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

    private String trainerName;

    public Student(User user) {
        super();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.roles;
        this.id = user.getId();
        this.enabled = true;
        this.completedTasks = new String("0");
    }

    public Student() {
        super();
        this.roles = "ROLE_STUDENT";
        this.completedTasks = new String("0");
    }

    public String userRole() {
        return "student";
    }


    public void setTaskCompleted(Task task){

        for(String i : this.completedTasks.split(","))
            if(task.getId().toString().equals(i))
                return;
        this.completedTasks += "," + task.getId();
    }

    public void unsetTaskCompleted(Task task){
        String[] completed = this.completedTasks.split(",");
        this.completedTasks = "0";
        for(String i : completed)
            if(!task.getId().toString().equals(i))
                this.completedTasks += "," + i;
    }

}
