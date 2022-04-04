package com.bootcamp.bootcampmanager.repository;

import com.bootcamp.bootcampmanager.model.Group;
import com.bootcamp.bootcampmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
