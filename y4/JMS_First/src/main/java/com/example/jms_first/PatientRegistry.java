package com.example.jms_first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PatientRegistry {
    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "jms/InquireQueue")
    public void handleInquiry(Inquiry inquiry) {
//         Look up the patient's medical history in the database
//        MedicalHistory history = database.getMedicalHistory(inquiry.getPatientName());

//         Send a response message to the return address specified in the inquiry
        Response response = new Response(new PatientHistory(inquiry.getPatientName(), null, null, null), inquiry.getCorrelationId());
        jmsTemplate.convertAndSend(inquiry.getReturnAddress(), response);

        System.out.printf("PatientRegistry: Sent inquiry resp about %s to %s! (id: %s)\n", inquiry.getPatientName(), inquiry.getReturnAddress(), inquiry.getCorrelationId());

    }

}
