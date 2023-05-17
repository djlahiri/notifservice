package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {
    @Mock
    private JavaMailSender emailSender;
    @InjectMocks
    private ServiceLayer service;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void sendNotification() {
        String to = "recipient@example.com";
        String subject = "Test Subject";
        String text = "Test Text";


        doNothing().when(emailSender).send(any(SimpleMailMessage.class));


        service.sendNotification(to, subject, text);


        verify(emailSender, times(1)).send(any(SimpleMailMessage.class));

    }
}