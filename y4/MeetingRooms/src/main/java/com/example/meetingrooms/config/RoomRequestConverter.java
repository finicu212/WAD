package com.example.meetingrooms.config;

import com.example.meetingrooms.entity.RoomRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class RoomRequestConverter {

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static RoomRequest fromJson(String json) throws IOException {
        return mapper.readValue(json, RoomRequest.class);
    }

    public static String toJson(RoomRequest roomRequest) throws JsonProcessingException {
        return mapper.writeValueAsString(roomRequest);
    }
}
