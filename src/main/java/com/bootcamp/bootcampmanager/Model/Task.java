package com.bootcamp.bootcampmanager.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
@Data  // added lombok so dont have to make getters and setters
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    Date dateFrom;
    Date dateTo;
    boolean isCompleted;
    List<Link> links;

}
