package com.example.demoausprobieren.component;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public String sendNotification(String message){
        return "Sending notification: " + message;
    }
}
