package com.example.jms_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmergencyUnit {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendNewPatientMessage(String patientName, String condition) {
        Patient patient = new Patient(patientName, condition);
        jmsTemplate.convertAndSend("jms/NewPatientTopic", patient);
        System.out.printf("Emergency Unit: %s has %s!\n", patientName, condition);
    }

}
