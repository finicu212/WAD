package com.example.meetingrooms.entity;

import com.example.meetingrooms.Services.RoomRequestService;
import com.example.meetingrooms.config.RoomRequestConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggerListener {

    private static final Logger log = LoggerFactory.getLogger(LoggerListener.class);

    @Autowired
    private RoomRequestService roomRequestService;

    @JmsListener(destination = "RoomRequests", containerFactory = "myFactory")
    public void receiveMessage(String strRequest) {
        RoomRequest roomRequest = null;
        try {
            roomRequest = RoomRequestConverter.fromJson(strRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("NEW REQUEST!!!!!!!");
        System.out.println(roomRequest.getRoomId());
        System.out.println(roomRequest.getStartTime());
        System.out.println(roomRequest.getEndTime());
    }
}
