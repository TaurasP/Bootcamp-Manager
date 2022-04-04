package com.bootcamp.bootcampmanager.Link;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String url;
}
