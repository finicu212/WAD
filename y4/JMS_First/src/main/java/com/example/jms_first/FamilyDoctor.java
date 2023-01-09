package com.example.jms_first;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FamilyDoctor {

    @JmsListener(destination = "jms/NewPatientTopic", containerFactory = "myFactory")
    public void handleNewPatientMessage(Patient patient) {
        System.out.printf("Family Doctor: Got news about %s!\n", patient.getName());
    }

}
