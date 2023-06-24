package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.MailDetail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendMail(String recipient, String subject, String msgBody) {
        try {
            SimpleMailMessage emailMessage = new SimpleMailMessage();
            emailMessage.setFrom(sender);
            emailMessage.setTo(recipient);
            emailMessage.setSubject(subject);
            emailMessage.setText(msgBody);
            mailSender.send(emailMessage);
            return "Email has been sent successfully...";
        } catch (Exception e) {
            return "Error while sending email!";
        }
    }


    @Override
    public String sendMailWithAttachment(MailDetail mailDetail) {
        // Creating a Mime Message
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachment to be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(mailDetail.getRecipient());
            mimeMessageHelper.setSubject(mailDetail.getSubject());
            mimeMessageHelper.setText(mailDetail.getMsgBody());

            // Adding the file attachment
            FileSystemResource file = new FileSystemResource(new File(mailDetail.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the email with attachment
            mailSender.send(mimeMessage);
            return "Email has been sent successfully...";
        }

        // Catch block to handle the MessagingException
        catch (MessagingException e) {

            // Display message when exception is occurred
            return "Error while sending email!!!";
        }
    }
}