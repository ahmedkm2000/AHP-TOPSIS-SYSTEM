package com.example.am.services;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendTextEmail(String receiver,String object,String text);

    void sendEmailWithAttachment();

    void sendHTMLEmail();
}