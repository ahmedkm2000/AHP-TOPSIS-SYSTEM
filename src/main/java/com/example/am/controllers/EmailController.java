package com.example.am.controllers;

import com.example.am.models.Email;
import com.example.am.models.Project;
import com.example.am.repository.ProjectRepository;
import com.example.am.services.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;
    @PostMapping("emails")
    public void sendEmailToExperts(@RequestBody Email email){
        emailService.sendTextEmail(email.getReceiver(),email.getObject(), email.getText());
    }
}
