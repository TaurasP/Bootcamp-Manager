package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.user.User;

import java.util.List;

public interface StudentService{

    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);

}