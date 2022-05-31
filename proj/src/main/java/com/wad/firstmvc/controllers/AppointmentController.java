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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    MaintenanceItemService maintenanceItemService;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/new")
    public String appointments(Model model) {
        model.addAttribute("maintenanceItems", maintenanceItemService.findAll());
        model.addAttribute("vehicles", vehicleRepository.findAll());
        model.addAttribute("appointment", new Appointment());

        return "newappointment";
    }

    @PostMapping("/new")
    public String addAppointment(Appointment appointment) {
        if (appointment.getId() == null)
            appointment.setId(new Random().nextLong());

        for (MaintenanceItem mi : appointment.getMaintenanceItems())
        {
            appointment.getVehicle().addMaintenanceItem(mi);
        }
        appointmentRepository.save(appointment);

        return "redirect:/dashboard";
    }
}
