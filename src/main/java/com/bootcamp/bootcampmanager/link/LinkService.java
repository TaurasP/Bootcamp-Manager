package com.bootcamp.bootcampmanager.link;

import com.bootcamp.bootcampmanager.student.Student;

import java.util.List;

public interface LinkService {

    List<Link> getAllLinks();
    void saveLink(Link link);
    Link getLinkById(long id);
    void deleteLinkById(long id);
}
