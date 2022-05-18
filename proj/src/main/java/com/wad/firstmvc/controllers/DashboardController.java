package com.wad.firstmvc.controllers;


import com.wad.firstmvc.domain.Appointment;
import com.wad.firstmvc.domain.MaintenanceItem;
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
import java.util.*;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    MaintenanceItemService maintenanceItemService;
    @Autowired
    AppointmentRepository appointmentRepository;

    public float costByMonth(int month, List<MaintenanceItem> maintenanceItems, List<Appointment> appointments) {
        Calendar cal = Calendar.getInstance();
        float cost = 0.0f;

        for (MaintenanceItem mi : maintenanceItems) {
            Appointment a = mi.getAppointment();
            cal.setTime(a.getDate());
            if (cal.get(Calendar.MONTH) == month) cost += mi.getPrice() + a.getWorkPrice();
        }

        return cost;
    }

    @GetMapping
    public String dashboard(Model model) {
        List<MaintenanceItem> maintenanceItems = (List<MaintenanceItem>) maintenanceItemService.findAll();
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        model.addAttribute("maintenanceItems", maintenanceItems);
        model.addAttribute("appointments", appointments);

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date dateNow = new Date();

//        Map<String, Float> costsByMonth = new HashMap<>();
        List<Float> costs = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
//            costsByMonth.put(Month.of(i).getDisplayName(TextStyle.FULL, Locale.ENGLISH), costByMonth(i, maintenanceItems, appointments));
            costs.add(costByMonth(i, maintenanceItems, appointments));
        }

        model.addAttribute("costs", costs);

        return "dashboard";
    }
}
