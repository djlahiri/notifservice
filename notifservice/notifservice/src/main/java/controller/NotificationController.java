package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ServiceLayer;

@RestController
public class NotificationController {
    private ServiceLayer service;

    @Autowired
    public NotificationController(ServiceLayer service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam("to") String to,
                                                   @RequestParam("subject") String subject,
                                                   @RequestParam("text") String text) {
        service.sendNotification(to, subject, text);
        return ResponseEntity.status(HttpStatus.OK).body("Notification sent successfully");
    }
}
