package com.bootcamp.bootcampmanager.task;

import com.bootcamp.bootcampmanager.filedb.FileDBService;
import com.bootcamp.bootcampmanager.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    public TaskService taskService;

    @Autowired
    public FileDBService fileDBService;

    @Autowired
    public StudentService studentService;

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
    public String saveTask(@ModelAttribute("task") Task task, @RequestParam("file") MultipartFile[] files) {
        task.setFileDB(fileDBService.saveFile(files[0], task));
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/update-task/{id}")
    public String showTaskFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    /* NEED TO FIX THIS */
    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable (value = "id") long id) {
        this.taskService.deleteTaskById(id);
        fileDBService.deleteFileById(taskService.getTaskById(id).getFileDB().getId());
        return "redirect:/tasks";
    }

    @GetMapping("/task/{id}")
    public String displayTaskPage(@PathVariable (value = "id") long id, Model model) {
        Task task = taskService.getTaskById(id);

        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/task-status/{id}")
    public String showTaskCheckbox(@PathVariable( value = "id") long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("taskStatus", task);
        return "task";
    }
}
