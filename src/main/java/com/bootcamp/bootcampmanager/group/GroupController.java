package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/listGroups")
    public String viewGroupsPage(Model model) {
        model.addAttribute("listGroups", groupService.getAllGroups());
        return "listGroups";
    }

    @GetMapping("/showNewGroupForm")
    public String showNewGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "showNewGroupForm";
    }
}
