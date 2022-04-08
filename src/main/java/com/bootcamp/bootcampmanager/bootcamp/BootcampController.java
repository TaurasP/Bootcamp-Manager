package com.bootcamp.bootcampmanager.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/link-student/{id}")
//    public String linkStudent(@PathVariable (value = "id") long id, Model model) {
//        model.addAttribute("bootcamp",  bootcampService.getBootcampById(id));
//        return "link-student";
//    }

    @RequestMapping(value = "/link-student/{id}")
    public String showCheckbox(@PathVariable (value = "id") long id, Model model) {
        boolean myBooleanVariable = false;
        model.addAttribute("myBooleanVariable", myBooleanVariable);
        model.addAttribute("bootcamp",  bootcampService.getBootcampById(id));
        return "link-student";
    }

//    @GetMapping("/create")
//    public String createExample(Model model) {
//        model.addAttribute("example", new Example());
//        return "example-form";
//    }
//
        @PostMapping("/insert/{id}")
        public String insertExample(@PathVariable (value = "id") long id, Model model, boolean myBooleanVariable) {
            model.addAttribute("myBooleanVariable", myBooleanVariable);
            return "redirect:/bootcamp/" + id;
        }

}
