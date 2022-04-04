package com.bootcamp.bootcampmanager.service;

import com.bootcamp.bootcampmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp {

    @Autowired
    public ProjectRepository projectRepository;

}
