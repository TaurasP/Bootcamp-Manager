package com.bootcamp.bootcampmanager.bootcamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller()
public class BootcampController {

    private final BootcampService bootcampService;

    @Autowired
    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @GetMapping("/bootcamps")
    public String showAllBootcamps(Model model) {
        model.addAttribute("listBootcamps", bootcampService.getAllBootcamps());
        return "bootcamp/allBootcamp";
    }

    @GetMapping("/addNewBootcamp")
    public String newBootcampForm(Model model) {
        model.addAttribute("bootcamp", new Bootcamp());
        return "bootcamp/new-bootcamp";
    }

    @PostMapping("/save-bootcamp")
    public String saveBootcamp(@ModelAttribute("bootcamp") Bootcamp bootcamp) {
        bootcampService.saveBootcamp(bootcamp);
//redirect leads to @GetMapping("/bootcamps")
        return "redirect:/bootcamps";
    }

}
