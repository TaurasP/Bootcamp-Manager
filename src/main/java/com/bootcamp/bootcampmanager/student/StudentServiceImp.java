package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.user.User;
import com.bootcamp.bootcampmanager.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException("Not found user: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }
}

