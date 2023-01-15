package com.example.meetingrooms.controllers;

import com.example.meetingrooms.Services.MeetingRoomService;
//import com.example.meetingrooms.Services.MeetingRoomServiceImp;
import com.example.meetingrooms.entity.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/request")
public class RoomRequestController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("rooms", meetingRoomService.getAllRooms());
        model.addAttribute("roomRequest", new RoomRequest());
        return "request";
    }

    @PostMapping("/submit")
    public String submitRequest(@ModelAttribute("roomRequest") RoomRequest roomRequest,
                                @RequestParam("roomId") Long roomId) {

        roomRequest.setRoomId(roomId);
        jmsTemplate.convertAndSend("RoomRequests", roomRequest);

        return "redirect:/request";
    }
}
