package com.example.jms_first;

import java.util.List;

public class PatientHistory {

    private String patientName;
    private List<String> conditions;
    private List<String> medications;
    private List<String> allergies;

    public PatientHistory(String patientName, List<String> conditions, List<String> medications, List<String> allergies) {
        this.patientName = patientName;
        this.conditions = conditions;
        this.medications = medications;
        this.allergies = allergies;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}