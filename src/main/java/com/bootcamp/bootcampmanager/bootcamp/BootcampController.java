package com.bootcamp.bootcampmanager.bootcamp;

import com.bootcamp.bootcampmanager.student.Student;
import com.bootcamp.bootcampmanager.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
public class BootcampController {

    private final BootcampService bootcampService;
    private final StudentService studentService;

    @Autowired
    public BootcampController(BootcampService bootcampService, StudentService studentService) {
        this.bootcampService = bootcampService;
        this.studentService = studentService;
    }

    @GetMapping("/bootcamps")
    public String showAllBootcamps(Model model) {
        model.addAttribute("listBootcamps", bootcampService.getAllBootcamps());
        /*return "bootcamp/allBootcamp";*/
        return "bootcamps";
    }

    @GetMapping("/new-bootcamp")
    public String showNewBootcampForm(Model model) {
        model.addAttribute("bootcamp", new Bootcamp());
        /*return "bootcamp/new-bootcamp";*/
        return "new-bootcamp";
    }

    @PostMapping("/save-bootcamp")
    public String saveBootcamp(@ModelAttribute("bootcamp") Bootcamp bootcamp) {
        bootcampService.saveBootcamp(bootcamp);
        return "redirect:/bootcamps";
    }

    @GetMapping("/update-bootcamp/{id}")
    public String showBootcampFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Bootcamp bootcamp = bootcampService.getBootcampById(id);
        model.addAttribute("bootcamp", bootcamp);
        return "update-bootcamp";
    }

    @GetMapping("/delete-bootcamp/{id}")
    public String deleteBootcamp(@PathVariable (value = "id") long id) {
        this.bootcampService.deleteBootcampById(id);
        return "redirect:/bootcamps";
    }

    @GetMapping("/bootcamp/{id}")
    public String showBootcamp(@PathVariable (value = "id") long id, Model model) {
        model.addAttribute("bootcamp",  bootcampService.getBootcampById(id));
        return "bootcamp";
    }

    @GetMapping(value = "/link-student/{id}")
    public String showCheckbox(@PathVariable (value = "id") long id, Model model) {
        model.addAttribute("studentList",  new StudentList());
        model.addAttribute("students",  studentService.getAllStudents());
        model.addAttribute("bootcamp",  bootcampService.getBootcampById(id));
        return "link-student";
    }

    @PostMapping("/insert/{id}")
    public String insertExample(@ModelAttribute("studentList") StudentList studentList, @PathVariable (value = "id") long id) {
        Bootcamp thisBootcamp = bootcampService.getBootcampById(id);
        for(Student student : studentList.getEnrolledStudents()){
            student.setBootcamp(thisBootcamp);
            studentService.saveStudent(student);
        }
        return "redirect:/bootcamp/" + id;
    }

    @GetMapping(value = "/unlink-student/{id}")
    public String unlinkStudent(@PathVariable (value = "id") long id, Model model) {

        Student student = studentService.getStudentById(id);
        long index = student.getBootcamp().getId();
        student.setBootcamp(null);
        studentService.saveStudent(student);
        return new String("redirect:/bootcamp/" + index);
    }

}
