package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Appointment;
import com.wad.firstmvc.domain.MaintenanceItem;
import com.wad.firstmvc.repositories.AppointmentRepository;
import com.wad.firstmvc.services.MaintenanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        for (Appointment a : appointments) {
            cal.setTime(a.getDate());
            if (cal.get(Calendar.MONTH) != (month - 1)) continue;

            float maintenanceItemsCost = 0.0f;
            for (MaintenanceItem mi : a.getVehicle().getMaintenanceItems())
                maintenanceItemsCost += mi.getPrice();

            cost += maintenanceItemsCost + a.getWorkPrice();
        }

//        for (MaintenanceItem mi : maintenanceItems) {
//            Appointment a = mi.getAppointment();
//            cal.setTime(a.getDate());
//            if (cal.get(Calendar.MONTH + 1) == month) cost += mi.getPrice() + a.getWorkPrice();
//        }

        return cost;
    }

    @GetMapping
    public String dashboard(Model model) {
        List<MaintenanceItem> maintenanceItems = (List<MaintenanceItem>) maintenanceItemService.findAll();
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        model.addAttribute("maintenanceItems", maintenanceItems);
        model.addAttribute("appointments", appointments);

        List<Float> costs = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            costs.add(costByMonth(i, maintenanceItems, appointments));
        }

        model.addAttribute("costs", costs);

        return "dashboard";
    }
}
