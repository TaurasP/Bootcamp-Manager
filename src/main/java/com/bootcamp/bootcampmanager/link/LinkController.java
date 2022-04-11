/*
package com.bootcamp.bootcampmanager.link;

import com.bootcamp.bootcampmanager.filedb.FileDB;
import com.bootcamp.bootcampmanager.student.Student;
import com.bootcamp.bootcampmanager.student.StudentService;
import com.bootcamp.bootcampmanager.task.Task;
import com.bootcamp.bootcampmanager.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    TaskService taskService;

    @GetMapping("/links")
    public String showAllLinks(Model model) {
        List<Link> linksList = linkService.getAllLinks();
        model.addAttribute("linksList", linksList);
        return "links";
    }


    @GetMapping("/new-link")
    public String showNewLinkForm(Model model) {
        Link link = new Link();
        model.addAttribute("link", link);
        return "new-link";
    }

    @PostMapping("/save-link")
    public String saveLink(@ModelAttribute("task") Task task, @ModelAttribute("link") Link link) {
        linkService.saveLink(link, task);
        return "redirect:/links";
    }

    @GetMapping("/update-link/{id}")
    public String showLinkFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Link link = linkService.getLinkById(id);
        model.addAttribute("link", link);
        return "update-link";
    }

    @GetMapping("/delete-link/{id}")
    public String deleteLink(@PathVariable (value = "id") long id) {
        this.linkService.deleteLinkById(id);
        return "redirect:/links";
    }
}
*/
