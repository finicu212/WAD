package com.example.jms_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class HospitalGateway {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "jms/NewPatientTopic")
    public void handleNewPatientMessage(Patient patient) {
        // Send a message to the jms/InquireQueue queue
        Inquiry inquiry = new Inquiry(patient.getName(), "jms/ResponseQueue");
        jmsTemplate.convertAndSend("jms/InquireQueue", inquiry);

        System.out.printf("HospitalGateway: Inquire about %s!\n", patient.getName());

        // Receive a reply from the jms/ResponseQueue queue
        Response response = (Response) jmsTemplate.receiveAndConvert("jms/ResponseQueue");

        System.out.printf("HospitalGateway: Got resp!\n");

        // Process the response
    }

}
