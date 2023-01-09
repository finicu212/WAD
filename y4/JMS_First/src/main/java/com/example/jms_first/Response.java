package com.example.jms_first;

public class Response {

    private PatientHistory medicalHistory;
    private String correlationId;

    public Response(PatientHistory medicalHistory, String correlationId) {
        this.medicalHistory = medicalHistory;
        this.correlationId = correlationId;
    }

    public PatientHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(PatientHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

}
