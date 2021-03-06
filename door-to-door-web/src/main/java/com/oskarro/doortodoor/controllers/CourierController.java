package com.oskarro.doortodoor.controllers;

import com.oskarro.doortodoor.model.Courier;
import com.oskarro.doortodoor.services.CourierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@RequestMapping
@Controller
public class CourierController {

    private final CourierService courierService;

    // injected CourierService via Controller (we don't need call out Autowired >4.2)
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @RequestMapping({"/couriers", "/couriers/index", "/couriers/index.html", "/couriers.html"})
    public String listCouriers(Model model) {

        // Spring MVC inject the model
        model.addAttribute("couriers", courierService.findAll());
        return "couriers/index";
    }

    // Couriers JSON Endpoint
    @GetMapping("/api/couriers")
    public @ResponseBody Set<Courier> getCouriersJson() {

        return courierService.findAll();
    }
}
