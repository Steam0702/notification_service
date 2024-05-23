package com.example.notification_service.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String body);
    void sendMessageWithAttachment(String to, String subject, String body, String filePath) throws MessagingException;
}
