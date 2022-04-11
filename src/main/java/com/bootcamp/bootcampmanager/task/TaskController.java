package com.bootcamp.bootcampmanager.task;

import com.bootcamp.bootcampmanager.filedb.FileDB;
import com.bootcamp.bootcampmanager.filedb.FileDBService;
import com.bootcamp.bootcampmanager.link.Link;
import com.bootcamp.bootcampmanager.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    public TaskService taskService;

    @Autowired
    public FileDBService fileDBService;

    @Autowired
    public LinkService linkService;

    /*@Autowired
    public LinkService linkService;*/

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
    public String saveTask(@ModelAttribute("task") Task task, @ModelAttribute("link") Link link, @RequestParam("files") MultipartFile[] files) {

        for (MultipartFile f : files) {
            task.setFileDB(fileDBService.saveFile(f, task));
        }
        linkService.saveLink(link, task);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    /* NEED TO FIX THIS */
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
        linkService.deleteLinkById(taskService.getTaskById(id).getLink().getId());
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
