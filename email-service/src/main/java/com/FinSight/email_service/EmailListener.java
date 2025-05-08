package com.FinSight.email_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailListener {

    private final JavaMailSender mailSender;
    private final ObjectMapper objectMapper;

    public EmailListener(JavaMailSender mailSender, ObjectMapper objectMapper) {
        this.mailSender = mailSender;
        this.objectMapper = objectMapper;
    }

    public String email = "jashdekavadiya@gmail.com";

    @RabbitListener(queues = "${app.queue.email}")
    public void handleEmailNotification(String messageJson) {
        System.out.println("Message Received!");

        try {
            EmailRequest request = objectMapper.readValue(messageJson, EmailRequest.class);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Credit Score Alert");
            message.setText(String.format(
                    "Your credit score is %.2f, which is below the threshold.",
                    request.getScore()
            ));

            mailSender.send(message);
            System.out.println("Cust_id: " + request.getId());
        } catch (Exception e) {
            System.err.println("Failed to process message or send email: " + e.getMessage());
        }
    }
}
