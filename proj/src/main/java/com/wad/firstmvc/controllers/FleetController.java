package com.wad.firstmvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fleet")
public class FleetController {
    @GetMapping
    public String fleet() {
        //returns the view
        return "fleet";
    }

    @PostMapping("/home")
    public String home() {
        //returns the view
        return "fleet";
    }
}
