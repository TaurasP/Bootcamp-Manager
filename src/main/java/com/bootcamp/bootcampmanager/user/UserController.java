package com.bootcamp.bootcampmanager.user;

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

    @GetMapping("/index")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "index";
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
        user.setRoles("ROLE_ADMIN");
        userService.saveUser(user);
        return "redirect:/index";
    }

    @GetMapping("/update-user/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/index";
    }
}