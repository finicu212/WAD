package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Appointment;
import com.wad.firstmvc.domain.MaintenanceItem;
import com.wad.firstmvc.repositories.AppointmentRepository;
import com.wad.firstmvc.repositories.VehicleRepository;
import com.wad.firstmvc.services.MaintenanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    MaintenanceItemService maintenanceItemService;
//    @Autowired
//    AppointmentRepository appointmentRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/new")
    public String maintenanceForm(Model model) {
//        model.addAttribute("maintenanceItems", maintenanceItemService.findAll());
        model.addAttribute("vehicles", vehicleRepository.findAll());
        model.addAttribute("maintenanceItem", new MaintenanceItem());

        return "newmaintenance";
    }

    @PostMapping("/new")
    public String addMaintenance(MaintenanceItem maintenanceItem) {
        if (maintenanceItem.getId() == null)
            maintenanceItem.setId(new Random().nextLong());

        maintenanceItemService.save(maintenanceItem);

        return "redirect:/dashboard";
    }
}
