package com.bootcamp.bootcampmanager.task;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.bootcamp.BootcampService;
import com.bootcamp.bootcampmanager.filedb.FileDBService;
import com.bootcamp.bootcampmanager.lecturer.LecturerService;
import com.bootcamp.bootcampmanager.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    public TaskService taskService;

    @Autowired
    public FileDBService fileDBService;

    @Autowired
    public StudentService studentService;

    @Autowired
    public LecturerService lecturerService;

    @Autowired
    public BootcampService bootcampService;

    @GetMapping("/tasks")
    public String showAllTasks(Model model) {

        List<Task> tasksList = taskService.getAllTasks();
        model.addAttribute("tasksList", tasksList);
        return "tasks";
    }

    @GetMapping("/new-task")
    public String showNewTaskForm(Model model) {
        Bootcamp id = new Bootcamp();
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("id", id);
        model.addAttribute("bootcamps", bootcampService.getAllBootcamps());
        return "new-task";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute("bootcamp") Bootcamp bootcamp, @ModelAttribute("task") Task task, @RequestParam("file") MultipartFile[] files) {
        task.setFileDB(fileDBService.saveFile(files[0], task));
        if(bootcamp.getId() != 0){
            try{
                Bootcamp camp = bootcampService.getBootcampById(bootcamp.getId());
                task.setBootcamp(camp);

            }
            catch(Exception e){
                System.out.println("\n\n\n\n Whoops!? Something went wrong!!!" + e.getMessage() + "\n\n\n\n");
            }
        }
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
        //fileDBService.deleteFileById(taskService.getTaskById(id).getFileDB().getId());
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

    @GetMapping("/lecturer-tasks/{id}")
    public String showLecturerTasks(@PathVariable( value = "id") long id, Model model) {

        List<Task> tasksList = new ArrayList<>();
        for(Bootcamp bootcamp : lecturerService.getLecturerById(id).getJoinedBootcamp())
                tasksList.addAll(bootcamp.getTasks());
        model.addAttribute("tasksList", tasksList);
        model.addAttribute("thisLecturer", lecturerService.getLecturerById(id));
        return "lecturer-tasks";
    }
}
