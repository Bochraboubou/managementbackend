package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.MailRepository;
import com.example.managementbackend.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    MailRepository mailRepository;

    public  Email sendEmail(Email mail)
    {String toEmail=mail.getDestinataire();
        String subject=mail.getObjet();
        String body=mail.getMessage();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("habessinour@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        //System.out.println("mail send successfully.....");

return mailRepository.save(mail);
    }

    // random

}
