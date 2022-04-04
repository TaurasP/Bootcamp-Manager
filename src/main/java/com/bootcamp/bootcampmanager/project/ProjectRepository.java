package com.bootcamp.bootcampmanager.project;

import com.bootcamp.bootcampmanager.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
