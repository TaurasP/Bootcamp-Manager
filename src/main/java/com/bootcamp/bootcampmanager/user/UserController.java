package com.bootcamp.bootcampmanager.user;

import com.bootcamp.bootcampmanager.admin.Admin;
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

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
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
        user.setFirstName("test");
        user.setLastName("Test");
        user.setEmail("test@test.com");
        user.setPassword("pass");
        user.setEnabled(true);
        userService.saveUser(user);
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