package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.MailDetail;

public interface MailService {
    String sendMail(String recipient, String subject, String msgBody);
    String sendMailWithAttachment(MailDetail mailDetail);
}
