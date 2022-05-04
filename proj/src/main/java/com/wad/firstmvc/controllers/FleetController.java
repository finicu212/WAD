package com.wad.firstmvc.controllers;


import com.wad.firstmvc.repositories.AppointmentRepository;
import com.wad.firstmvc.services.MaintenanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fleet")
public class FleetController {
    @Autowired
    MaintenanceItemService maintenanceItemService;
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping
    public String fleet(Model model) {
        model.addAttribute("maintenanceItems", maintenanceItemService.findAll());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "fleet";
    }
}
