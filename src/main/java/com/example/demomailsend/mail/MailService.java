package com.example.demomailsend.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTextMail(String recipient, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }

    public void sendHtmlMail(String recipient, String subject, String html, String fileName, File file) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true); // true = multipart message
        messageHelper.setTo(recipient);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true); // default: false = text/plain
        messageHelper.addAttachment(fileName, file);

        javaMailSender.send(message);
    }

}