package com.example.jms_first;

public class Patient {

    private String name;
    private String condition;

    public Patient(String name, String condition) {
        this.name = name;
        this.condition = condition;
    }

    public Patient() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}