package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Appointment;
import com.wad.firstmvc.domain.MaintenanceItem;
import com.wad.firstmvc.domain.Vehicle;
import com.wad.firstmvc.repositories.AppointmentRepository;
import com.wad.firstmvc.repositories.VehicleRepository;
import com.wad.firstmvc.services.MaintenanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/fleet")
public class FleetController {
//    @Autowired
//    MaintenanceItemService maintenanceItemService;
//    @Autowired
//    AppointmentRepository appointmentRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        System.out.println(model.getAttribute("vehicles"));
        return "fleet";
    }

    @GetMapping("/new")
    public String showVehiclesForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());

        return "newvehicle";
    }

    @PostMapping("/new")
    public String addVehicle(Vehicle vehicle) {
        if (vehicle.getId() == null)
            vehicle.setId(new Random().nextLong());
        vehicleRepository.save(vehicle);

        return "redirect:/fleet";
    }
}
