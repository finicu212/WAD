package com.example.meetingrooms.controllers;

import com.example.meetingrooms.Services.MeetingRoomService;
import com.example.meetingrooms.Services.RoomRequestService;
import com.example.meetingrooms.entity.MeetingRoom;
import com.example.meetingrooms.entity.RoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/approver")
public class ApproveDenyController {

    @Autowired
    private RoomRequestService roomRequestService;

    @Autowired
    private MeetingRoomService meetingRoomService;

    @GetMapping
    public String approveDenyForm(Model model) {
        Map<Long, MeetingRoom> rooms = new HashMap<>();
        List<RoomRequest> pendingRequests = roomRequestService.getPendingRequests();
        for (RoomRequest request : pendingRequests) {
            MeetingRoom room = meetingRoomService.findById(Math.toIntExact(request.getRoomId()));
            rooms.put(request.getId(), room);
        }
        model.addAttribute("roomRequests", pendingRequests);
        model.addAttribute("rooms", rooms);
        return "approver";
    }


    @PostMapping("/approve")
    public String approveRequest(@RequestParam("requestId") Long requestId) {
        RoomRequest roomRequest = roomRequestService.getRequestById(requestId);
        roomRequest.setApproved(true);
        meetingRoomService.markRoomAsUnavailable(Math.toIntExact(roomRequest.getRoomId()), roomRequest.getStartTime(), roomRequest.getEndTime());
        roomRequestService.saveRequest(roomRequest);
        return "redirect:/approver";
    }

    @PostMapping("/deny")
    public String denyRequest(@RequestParam("requestId") Long requestId) {
        RoomRequest roomRequest = roomRequestService.getRequestById(requestId);
        roomRequest.setApproved(false);
        roomRequestService.deleteRequest(roomRequest);
        return "redirect:/approver";
    }
}
