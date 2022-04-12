package com.bootcamp.bootcampmanager.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentHelper {


    private StudentService studentService;

    @Autowired
    public StudentHelper(StudentService studentService) {
        this.studentService = studentService;
    }

    public String isTaskCompleted(long taskId, long studentId){

        String completedId = studentService.getStudentById(studentId).getCompletedTasks();
        if(completedId == null)
            return "null?";
        for(String id : completedId.split(",")){
            if(id.equals("null") || id.equals(","))
                continue;
            try{
                if(Long.parseLong(id) == taskId)
                    return "completed";
            } catch (Exception e) {
                return "not completed";
            }
        }
        return "not completed";
    }
}
