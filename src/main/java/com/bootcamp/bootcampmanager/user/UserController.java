package com.bootcamp.bootcampmanager.user;

import com.bootcamp.bootcampmanager.admin.Admin;
import com.bootcamp.bootcampmanager.admin.AdminService;
import com.bootcamp.bootcampmanager.lecturer.Lecturer;
import com.bootcamp.bootcampmanager.lecturer.LecturerService;
import com.bootcamp.bootcampmanager.student.Student;
import com.bootcamp.bootcampmanager.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<Admin> adminsList = adminService.getAllAdmins();
        model.addAttribute("adminsList", adminsList);
        List<Lecturer> lecturersList = lecturerService.getAllLecturers();
        model.addAttribute("lecturersList", lecturersList);
        List<Student> studentsList = studentService.getAllStudents();
        model.addAttribute("studentsList", studentsList);
        return "users";
    }

    @GetMapping("/new-user")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new-user";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") User user) {
        user.setEnabled(true);
        if(user.getRoles() == null)
            return "redirect:/users";
        if(user.getRoles().equals("ROLE_ADMIN")){
            Admin admin = new Admin(user);
            adminService.saveAdmin(admin);
        }
        else if(user.getRoles().equals("ROLE_STUDENT")){
            Student student = new Student(user);
            studentService.saveStudent(student);
        }
        else if(user.getRoles().equals("ROLE_LECTURER")){
            Lecturer lecturer = new Lecturer(user);
            lecturerService.saveLecturer(lecturer);
        }
        return "redirect:/users";
    }

    @GetMapping("/update-user/{id}")
    public String showUserFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/users";
    }
}