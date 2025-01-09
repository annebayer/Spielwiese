package com.example.demoausprobieren.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final NotificationService notificationService;

    @Autowired
    public UserController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public String notifyUser() {
        return notificationService.sendNotification("Welcome to our service!");
    }

    @GetMapping("/component")
    public String componentExample() {
        return notifyUser();
    }
}
