package com.yanis.realestateagency.controller;

import com.yanis.realestateagency.model.PropertyType;
import com.yanis.realestateagency.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/propertytype")
public class PropertyTypeController {
    @Autowired
    private PropertyTypeService propertyTypeService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("propertyTypes", propertyTypeService.getAll());
        return "propertyType/list";
    }

    @GetMapping("/add")
    public String displayAddForm(PropertyType propertyType) {
        return "propertyType/add";
    }

    @PostMapping("/add")
    public String processAdd(PropertyType propertyType) {
        propertyTypeService.add(propertyType);
        return "redirect:/propertyType/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        PropertyType propertyType = propertyTypeService.findById(id);
        model.addAttribute("propertyType", propertyType);
        return "propertyType/update";
    }

    @PostMapping("/update")
    public String processUpdate(PropertyType propertyType) {
        propertyTypeService.update(propertyType);
        return "redirect:/propertyType/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        propertyTypeService.delete(id);
        return "redirect:/propertyType/list";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/propertyType/list";
    }
}
