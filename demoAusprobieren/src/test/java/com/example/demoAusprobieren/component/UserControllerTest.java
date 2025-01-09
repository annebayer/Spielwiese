package com.example.demoausprobieren.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private UserController classUnderTest;

    @Test
    void notifyUser() {
        when(notificationService.sendNotification(anyString())).thenReturn("bla");
        assertThat(classUnderTest.notifyUser()).isEqualTo("bla");
    }

    @Test
    void notifiyUserWithoutMockito(){
        NotificationService notificationService1 = new NotificationService();
        UserController controller = new UserController(notificationService1);

        assertThat(controller.notifyUser()).isEqualTo("Sending notification: Welcome to our service!");

    }
}