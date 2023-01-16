package com.example.meetingrooms.controllers;

import com.example.meetingrooms.MeetingRoomApplication;
import com.example.meetingrooms.Services.MeetingRoomService;
//import com.example.meetingrooms.Services.MeetingRoomServiceImp;
import com.example.meetingrooms.entity.RoomRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
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
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
    @PostMapping("/submit")
    public String submitRequest(@ModelAttribute("roomRequest") RoomRequest roomRequest,
                                @RequestParam("roomId") Long roomId) {

        roomRequest.setRoomId(roomId);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            jmsTemplate.convertAndSend("RoomRequests", objectMapper.writeValueAsString(roomRequest));
            jmsTemplate.setMessageConverter(messageConverter());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/request";
    }
}
