package com.example.meetingrooms.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String title;
    private String start;
    private String end;

    public Event(String title, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.start = start.format(DateTimeFormatter.ISO_DATE_TIME);
        this.end = end.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
