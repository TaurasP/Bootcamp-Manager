package com.bootcamp.bootcampmanager.course;

import com.bootcamp.bootcampmanager.group.Group;
import com.bootcamp.bootcampmanager.task.Task;
import com.bootcamp.bootcampmanager.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/courses")
    public String viewCoursesPage(Model model) {
        model.addAttribute("coursesList", courseService.getAllCourse());
        return "courses";
    }

    @GetMapping("/new-course")
    public String showNewCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "new-course";
    }

    @GetMapping("/update-course/{id}")
    public String editCourseForm(@PathVariable( value = "id") long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        if(course.isPresent())
            model.addAttribute("course", course.get());
        return "update-course";
    }

    @GetMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable (value = "id") long id) {
        this.courseService.deleteGroupById(id);
        return "redirect:/courses";
    }

    @PostMapping("/save-course")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/course/{id}")
    public String displayCourseProfile(@PathVariable( value = "id") long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        List<Task> tasks = taskService.getTasksByCourse(id);
        model.addAttribute("tasks",tasks);
        if(course.isPresent())
            model.addAttribute("course", course.get());
        return "course";
    }
}
