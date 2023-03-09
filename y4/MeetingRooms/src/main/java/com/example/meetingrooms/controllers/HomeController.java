package com.example.meetingrooms.controllers;

import com.example.meetingrooms.Services.MeetingRoomService;
import com.example.meetingrooms.entity.Event;
import com.example.meetingrooms.entity.MeetingRoom;
import com.example.meetingrooms.entity.TimeInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping
public class HomeController {

    private final MeetingRoomService meetingRoomService;

    @Autowired
    public HomeController(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<MeetingRoom> rooms = meetingRoomService.getAllRooms();
        List<Event> events = new ArrayList<>();
        for (MeetingRoom room : rooms) {
            List<TimeInterval> unavailableIntervals = room.getUnavailableIntervals();
            for (TimeInterval unavailableInterval : unavailableIntervals) {
                System.out.println("Unavailable interval which ends at: " + unavailableInterval.getEndTime().toString());
                Event event = new Event(room.getName(), unavailableInterval.getStartTime(), unavailableInterval.getEndTime());
                events.add(event);
            }
        }
        model.addAttribute("events", events);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/editor")
    public String editor() {
        return "editor";
    }
}
