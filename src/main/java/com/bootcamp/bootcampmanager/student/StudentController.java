package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.user.User;
import com.bootcamp.bootcampmanager.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String showAllStudents(Model model) {
        List<Student> studentsList = studentService.getAllStudents();
        model.addAttribute("studentsList", studentsList);
        return "students";
    }


    @GetMapping("/new-student")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        student.setEnabled(true);
        student.setRoles("ROLE_STUDENT");
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update-student/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}
