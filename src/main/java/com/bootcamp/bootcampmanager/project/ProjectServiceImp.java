package com.bootcamp.bootcampmanager.project;

import com.bootcamp.bootcampmanager.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp {

    @Autowired
    public ProjectRepository projectRepository;

}
