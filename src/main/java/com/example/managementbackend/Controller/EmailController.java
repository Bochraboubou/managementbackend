package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.MailRepository;
import com.example.managementbackend.Service.EmailService;
import com.example.managementbackend.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    MailRepository mailRepository;
    @Autowired
    EmailService emailService;


    @PostMapping("/send")
    public String  send(@RequestBody Email mail)
    {
        emailService.sendEmail(mail);
        mailRepository.save(mail);
        return "message envoyeeee ...";
    }
}
