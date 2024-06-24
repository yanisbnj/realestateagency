package com.yanis.realestateagency.controller;

import com.yanis.realestateagency.model.Owner;
import com.yanis.realestateagency.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("owners", this.ownerService.getAllOwners());
        return "owner/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/add";
    }

    @PostMapping("/add")
    public String processAdd(Owner owner) {
        this.ownerService.addOwner(owner);
        return "redirect:/owner/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        Owner owner = this.ownerService.getOwnerById(id);
        model.addAttribute("owner", owner);
        return "owner/update";
    }

    @PostMapping("/update")
    public String processUpdate(Owner owner) {
        this.ownerService.updateOwner(owner.getId(), owner);
        return "redirect:/owner/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.ownerService.deleteOwner(id);
        return "redirect:/owner/list";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/owner/list";
    }
}
