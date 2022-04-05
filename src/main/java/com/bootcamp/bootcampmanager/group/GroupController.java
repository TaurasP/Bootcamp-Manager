package com.bootcamp.bootcampmanager.group;

import com.bootcamp.bootcampmanager.group.GroupService;
import com.bootcamp.bootcampmanager.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/listGroups")
    public String viewGroupsPage(Model model) {
        model.addAttribute("allGroups", groupService.getAllGroups());
        return "listGroups";
    }

    @GetMapping("/createGroup")
    public String showNewGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "createGroup";
    }

    @GetMapping("/editGroup/{id}")
    public String editGroupForm(@PathVariable( value = "id") long id, Model model) {
        Group group = groupService.getGroupById(id);
        model.addAttribute("group", group);
        return "editGroup";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable (value = "id") long id) {
        this.groupService.deleteGroupById(id);
        return "redirect:/listGroups";
    }

    @PostMapping("/save-group")
    public String saveUser(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/listGroups";
    }
}
