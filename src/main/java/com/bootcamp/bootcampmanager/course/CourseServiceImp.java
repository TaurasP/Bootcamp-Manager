/*
package com.bootcamp.bootcampmanager.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService{

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void deleteGroupById(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
}
*/
