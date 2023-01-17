package com.example.meetingrooms.controllers;

import com.example.meetingrooms.Services.MeetingRoomService;
import com.example.meetingrooms.entity.Event;
import com.example.meetingrooms.entity.MeetingRoom;
import com.example.meetingrooms.entity.TimeInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {
    private final MeetingRoomService meetingRoomService;

    @Autowired
    public CalendarController(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping("/calendar")
    public String getCalendar(Model model) {
        List<MeetingRoom> rooms = meetingRoomService.getAllRooms();
        List<Event> events = new ArrayList<>();
        for (MeetingRoom room : rooms) {
            List<TimeInterval> unavailableIntervals = room.getUnavailableIntervals();
            for (TimeInterval unavailableInterval : unavailableIntervals) {
                Event event = new Event(room.getName(), unavailableInterval.getStartTime(), unavailableInterval.getEndTime());
                events.add(event);
            }
        }
        model.addAttribute("events", events);
        return "calendar";
    }
}
