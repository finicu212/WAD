package com.wad.firstmvc.bootstrap;

import com.wad.firstmvc.domain.Appointment;
import com.wad.firstmvc.domain.MaintenanceItem;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.domain.Vehicle;
import com.wad.firstmvc.repositories.AppointmentRepository;
import com.wad.firstmvc.repositories.VehicleRepository;
import com.wad.firstmvc.services.MaintenanceItemService;
import com.wad.firstmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    MaintenanceItemService maintenanceItemService;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public void run(String... args) throws Exception {

//        User u;
//        u = new User("avirtopeanu", "avirtopeanu@gmail.com");
//        userService.save(u);
//        u = new User("xelav", "xelav@gmail.com");
//        userService.save(u);
//        u = new User("finicu", "finicu@gmail.com");
//        userService.save(u);
//
//        MaintenanceItem maintenanceItem;
//        Appointment appointment;
//        Vehicle v;
//
//        // objects
//        v = new Vehicle("Dacia", "Logan", 1600);
//        appointment = new Appointment("Oil Change", "Vericu SRL", 50.0f, parseDate("2022-05-13"));
//        maintenanceItem = new MaintenanceItem("Diesel Oil", "Signature Series Max-Duty Synthetic Diesel Oil 10W-30", "AMSOIL", 59.59f);
//
//        // relations
//        appointment.addMaintenanceItem(maintenanceItem);
//        v.addMaintenanceItem(maintenanceItem);
//        v.addAppointment(appointment);
//
//        // save to db
//        maintenanceItemService.save(maintenanceItem);
//        appointmentRepository.save(appointment);
//        vehicleRepository.save(v);//        // ---
//
//        v = new Vehicle("Honda", "Civic", 1800);
//
//        appointment = new Appointment("ITP Inspection", "Militari RAR Garage", 200.0f, parseDate("2022-05-13"));
//        v.addAppointment(appointment);
//
//        appointmentRepository.save(appointment);
//        vehicleRepository.save(v);
//        // ---
//
//        v = new Vehicle("Mazda", "RX8", 1300);
//        appointment = new Appointment("Engine Rebuild", "Vericu SRL", 2000.0f, parseDate("2022-06-21"));
//        maintenanceItem = new MaintenanceItem("Engine", "Whole 1.3L rotary engine", "Junkyard S.A.", 700.0f);
//
//        appointment.addMaintenanceItem(maintenanceItem);
//        v.addMaintenanceItem(maintenanceItem);
//        v.addAppointment(appointment);
//
//        maintenanceItemService.save(maintenanceItem);
//        appointmentRepository.save(appointment);
//        vehicleRepository.save(v);
//        // ---

        List<User> users = userService.findAll();
        users.forEach(System.out::println);

        List<MaintenanceItem> maintenanceItems = maintenanceItemService.findAll();
        maintenanceItems.forEach(System.out::println);

        List<Vehicle> vehicles = (List<Vehicle>) vehicleRepository.findAll();
        vehicles.forEach(System.out::println);

        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        appointments.forEach(System.out::println);
    }
}
