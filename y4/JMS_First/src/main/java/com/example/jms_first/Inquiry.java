package com.example.jms_first;

import java.util.UUID;

public class Inquiry {

    private String patientName;
    private String returnAddress;
    private String correlationId;

    public Inquiry(String patientName, String returnAddress) {
        this.patientName = patientName;
        this.returnAddress = returnAddress;
        this.correlationId = UUID.randomUUID().toString();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

}

