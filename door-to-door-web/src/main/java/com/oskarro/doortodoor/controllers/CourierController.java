package com.oskarro.doortodoor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourierController {

    @RequestMapping({"/couriers", "/couriers/index", "/couriers/index.html"})
    public String listCouriers() {
        return "couriers/index";
    }
}
