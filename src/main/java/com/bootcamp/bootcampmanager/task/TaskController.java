package com.bootcamp.bootcampmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/tasks")
    public String showAllTasks(Model model) {
        List<Task> tasksList = taskService.getAllTasks();
        model.addAttribute("tasksList", tasksList);
        return "tasks";
    }

    @GetMapping("/new-task")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "new-task";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/update-task/{id}")
    public String showTaskFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable (value = "id") long id) {
        this.taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }
}
