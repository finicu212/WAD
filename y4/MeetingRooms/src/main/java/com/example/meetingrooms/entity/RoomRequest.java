package com.example.meetingrooms.entity;

import org.apache.activemq.util.BooleanEditor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class RoomRequest {
    @Id
    @GeneratedValue
    private Long id;

    private Long roomId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;

    private Boolean approved;

    public RoomRequest() {
        super();
        this.approved = false;
    }

    public RoomRequest(Long roomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.approved = false;
    }

    public Long getRoomId() {
        return roomId;
    }

    public Boolean getApproved() {
        return approved;
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

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}