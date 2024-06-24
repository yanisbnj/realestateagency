package com.yanis.realestateagency.controller;

import com.yanis.realestateagency.model.Property;
import com.yanis.realestateagency.service.OwnerService;
import com.yanis.realestateagency.service.PropertyService;
import com.yanis.realestateagency.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyTypeService propertyTypeService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "property/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("propertyTypes", propertyTypeService.getAll());
        model.addAttribute("owners", ownerService.getAllOwners());
        return "property/add";
    }

    @PostMapping("/add")
    public String processAdd(Property property) {
        propertyService.addProperty(property);
        return "redirect:/property/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        Property property = propertyService.getPropertyById(id);
        model.addAttribute("property", property);
        return "property/update";
    }

    @PostMapping("/update")
    public String processUpdate(Property property) {
        propertyService.updateProperty(property.getPropertyId(), property);
        return "redirect:/property/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        propertyService.deleteProperty(id);
        return "redirect:/property/list";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/property/list";
    }
}
