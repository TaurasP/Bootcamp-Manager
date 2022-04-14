package com.bootcamp.bootcampmanager.task;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.bootcamp.BootcampService;
import com.bootcamp.bootcampmanager.filedb.FileDBService;
import com.bootcamp.bootcampmanager.lecturer.Lecturer;
import com.bootcamp.bootcampmanager.lecturer.LecturerService;
import com.bootcamp.bootcampmanager.student.Student;
import com.bootcamp.bootcampmanager.student.StudentHelper;
import com.bootcamp.bootcampmanager.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

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

        Lecturer thisLecturer = lecturerService.getLecturerById(id);
        List<Task> tasksList = new ArrayList<>();
        FilterContainer filterContainer = new FilterContainer( -1);
        System.out.println("\n\n From Getter!!!!" + filterContainer.getTask() + "\n\n\n\n");
        if(filterContainer.showTable() && filterContainer.getTask() > 0){
            Task task = taskService.getTaskById(filterContainer.getTask());
            List<Student> students = task.getBootcamp().getStudents();
            model.addAttribute("task", task);
            model.addAttribute("students", students);
            model.addAttribute("helper", new StudentHelper(studentService));
        }


        for(Bootcamp bootcamp : lecturerService.getLecturerById(id).getJoinedBootcamp())
                tasksList.addAll(bootcamp.getTasks());
        model.addAttribute("filterContainer", filterContainer);
        model.addAttribute("id", id);
        model.addAttribute("tasksList", tasksList);
        model.addAttribute("bootcamps", thisLecturer.getJoinedBootcamp());
        model.addAttribute("thisLecturer", thisLecturer);
        return "lecturer-tasks";
    }

    @PostMapping(path = "/filter/{id}")
    public String Filter(@PathVariable( value = "id") long id, @ModelAttribute("FilterContainer") FilterContainer filterContainer, Model model) {

        filterContainer.setShow();
        filterContainer.setId(filterContainer.getSelectedTask());
        System.out.println("\n\n From poster!!!" + filterContainer.getSelectedTask() +  "\n\n\n\n");

        return "redirect:/lecturer-tasks/" + id;
    }
}
