package com.bootcamp.bootcampmanager.bootcamp;


import com.bootcamp.bootcampmanager.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentList {

    public List<Student> enrolledStudents = new ArrayList<>();

}
