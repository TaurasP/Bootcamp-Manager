package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
