package com.bootcamp.bootcampmanager.bootcamp;

import com.bootcamp.bootcampmanager.student.Student;
import com.bootcamp.bootcampmanager.student.StudentService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements Converter<String, Student> {

    private final StudentService studentService;

    public StudentConverter(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student convert(String id){
        return studentService.getStudentById(Integer.parseInt(id));
    }

}
