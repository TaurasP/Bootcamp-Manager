/*
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

    @GetMapping("/groups")
    public String viewGroupsPage(Model model) {
        model.addAttribute("groupsList", groupService.getAllGroups());
        return "groups";
    }

    @GetMapping("/new-group")
    public String showNewGroupForm(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "new-group";
    }

    @PostMapping("/save-group")
    public String saveGroup(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/update-group/{id}")
    public String editGroupForm(@PathVariable( value = "id") long id, Model model) {
        Group group = groupService.getGroupById(id);
        model.addAttribute("group", group);
        return "update-group";
    }

    @GetMapping("/delete-group/{id}")
    public String deleteGroup(@PathVariable (value = "id") long id) {
        this.groupService.deleteGroupById(id);
        return "redirect:/groups";
    }

    @GetMapping("/groupProfile/{id}")
    public String displayGroupProfile(@PathVariable( value = "id") long id, Model model) {
        Group thisGroup = groupService.getGroupById(id);
        model.addAttribute("thisGroup", thisGroup);
        return "groupProfile";
    }

}
*/
