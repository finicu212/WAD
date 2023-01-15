package com.example.meetingrooms.controllers;

import com.example.meetingrooms.Services.MeetingRoomServiceImp;
import com.example.meetingrooms.entity.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MeetingRoomController {
    @Autowired
    private MeetingRoomServiceImp meetingRoomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        List<MeetingRoom> rooms = meetingRoomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/rooms/add")
    public String addRoomForm(Model model) {
        model.addAttribute("room", new MeetingRoom());
        return "addroom";
    }

    @PostMapping("/rooms")
    public String addRoom(@ModelAttribute MeetingRoom room) {
        meetingRoomService.addRoom(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/{id}/edit")
    public String updateRoomForm(@PathVariable("id") int id, Model model) {
        MeetingRoom room = meetingRoomService.findById(id);
        model.addAttribute("room", room);
        return "updateroom";
    }

    @PutMapping("/rooms/{id}")
    public String updateRoom(@PathVariable("id") int id, @ModelAttribute MeetingRoom room) {
        meetingRoomService.updateRoom(room, id);
        return "redirect:/rooms";
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable("id") int id) {
        System.out.printf("DELETE in controller\n");
        meetingRoomService.deleteRoom(id);
        return "redirect:/rooms";
    }
}
