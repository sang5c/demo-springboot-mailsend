package com.example.demomailsend.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.File;

@SpringBootTest
class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void textMailSendTest() {
        mailService.sendTextMail("@gmail.com", "subject", "text");
    }

    @Test
    public void htmlMailSendTest() throws MessagingException {
        String filePath = "파일 경로";
        File file = new File(filePath);
        mailService.sendHtmlMail("@gmail.com", "제목", "<h1>안녕</h1>", "readme.md", file);
    }


}