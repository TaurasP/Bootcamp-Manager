package com.bootcamp.bootcampmanager.student;

import com.bootcamp.bootcampmanager.bootcamp.Bootcamp;
import com.bootcamp.bootcampmanager.bootcamp.BootcampService;
import com.bootcamp.bootcampmanager.task.Task;
import com.bootcamp.bootcampmanager.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class StudentController {


    private final StudentService studentService;
    private final BootcampService bootcampService;
    private final TaskService taskService;

    @Autowired
    public StudentController(StudentService studentService,
                             BootcampService bootcampService,
                             TaskService taskService) {
        this.studentService = studentService;
        this.bootcampService = bootcampService;
        this.taskService = taskService;
    }

    @GetMapping("/students")
    public String showAllStudents(Model model) {
        model.addAttribute("bootcampList", bootcampService.getAllBootcamps());
        model.addAttribute("taskList", taskService.getAllTasks());
        model.addAttribute("studentsList", studentService.getAllStudents());
        model.addAttribute("searchInfo", new SearchInfo());
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
    public String showStudentFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/info-student/{id}")
    public String showStudentInfo(@PathVariable(value = "id") long id, Model model) {
//        studentService.getStudentById(id).getBootcamp().g
        model.addAttribute("student", studentService.getStudentById(id));
        return "student";
    }

    @PostMapping("/printMSG")
    public String print(@ModelAttribute("searchInfo") SearchInfo searchInfo) {
        Long campId = searchInfo.getCampId();
        Long taskId = searchInfo.getTaskId();
        if (campId == 0 || taskId == 0) {
            System.out.println("For Null");
        }

        System.out.println("Hi I'm working." + campId + " " + taskId);
        return "redirect:/students";
    }

    @PostMapping("/sorted-students")
    public String showSortedStudents(@ModelAttribute("searchInfo") SearchInfo searchInfo, Model model) {
        Long taskId = searchInfo.getTaskId();
        Long campId = searchInfo.getCampId();
        if (taskId == 0 || campId == 0) {
            return "redirect:/students";
        }
        Map<Student, Boolean> map = studentService.getAllStudentsByBootcampIdAndTaskId(campId, taskId);

        System.out.println("Map size: "+map.size());

        model.addAttribute("bootcamp", bootcampService.getBootcampById(campId).getName());
        model.addAttribute("task", taskService.getTaskById(taskId).getName());
        model.addAttribute("map",
                studentService.getAllStudentsByBootcampIdAndTaskId(campId, taskId)
        );
        return "sorted-students";
    }

}
