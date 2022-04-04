package com.bootcamp.bootcampmanager.repository;

import com.bootcamp.bootcampmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
