package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    @Autowired
    private JavaMailSender emailSender;

    public void sendNotification(String to,String subject,String text){
        SimpleMailMessage notif=new SimpleMailMessage();
        notif.setTo(to);
        notif.setSubject(subject);
        notif.setText(text);

        emailSender.send(notif);

    }

}
