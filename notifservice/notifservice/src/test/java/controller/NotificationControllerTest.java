package controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.ServiceLayer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class NotificationControllerTest {

    @Mock
    private ServiceLayer service;

    private NotificationController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new NotificationController(service);
    }

    @Test
    void sendNotification() {

        String to = "recipient@example.com";
        String subject = "Test Subject";
        String text = "Hello, this is a test notification";

        doNothing().when(service).sendNotification(to,subject,text);

        ResponseEntity<String> response = controller.sendNotification(to, subject, text);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Notification sent successfully", response.getBody());


        Mockito.verify(service).sendNotification(to,subject,text);
    }
}