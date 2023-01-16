package com.example.meetingrooms.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class RoomRequest {
    private Long roomId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;

    public RoomRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RoomRequest(Long roomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getRoomId() {
        return roomId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}