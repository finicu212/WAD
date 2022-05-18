package com.wad.firstmvc.controllers;


import com.wad.firstmvc.repositories.AppointmentRepository;
import com.wad.firstmvc.services.MaintenanceItemService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    MaintenanceItemService maintenanceItemService;
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("maintenanceItems", maintenanceItemService.findAll());
        model.addAttribute("appointments", appointmentRepository.findAll());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNow = new Date();

        Map<String, Double> costsByMonth = new HashMap<>();
        for (int i = 1; i <= 12; i++)
        {
            costsByMonth.put(Month.of(i).getDisplayName(TextStyle.FULL, Locale.ENGLISH), 0.0);
        }

        return "dashboard";
    }
}
