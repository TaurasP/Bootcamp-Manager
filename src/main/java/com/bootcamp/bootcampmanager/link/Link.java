package com.bootcamp.bootcampmanager.link;

import com.bootcamp.bootcampmanager.task.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "links")
@Getter
@Setter
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String url;

    /*@ManyToOne
    @JoinColumn(name="task_id")
    private Task task;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    public Link(String url, Task task) {
        this.url = url;
        this.task = task;
    }
}
