package com.example.notification_service.controller;

import com.example.notification_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/send/{email-address}")
    public ResponseEntity<String> send(@PathVariable(value = "email-address") String emailAddress) {
        try {
            emailService.sendSimpleMessage(emailAddress, "Welcome", "This is a welcome email for your!!");
            log.info("Email sent to {}", emailAddress);
            return ResponseEntity.ok("Email sent to " + emailAddress);
        } catch (MailException e){
            log.error("Error while sending email to {} : {}", emailAddress, e.getMessage());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
