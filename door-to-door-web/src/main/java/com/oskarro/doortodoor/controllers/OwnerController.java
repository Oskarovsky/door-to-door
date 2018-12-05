package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    // injected OwnerService via Controller (we don't need call out Autowired >4.2)
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        // Spring MVC inject the model
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }


    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }


}
