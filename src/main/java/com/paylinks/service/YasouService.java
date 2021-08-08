package com.paylinks.service;

import com.paylinks.dto.MailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class YasouService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    public String send(MailRequest request) {
        try {
            if (request.getType().equals("text")) {
                sendEmail(request);
            } else if (request.getType().equals("html")) {
                sendHtmlEmail(request);
            }
            logger.info("Send email success");
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        logger.info("Send done");
        return "Success";
    }

    void sendEmail(MailRequest request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getReciever());
        msg.setSubject(request.getSubject());
        msg.setText(request.getContent());
        javaMailSender.send(msg);
    }

    public void sendHtmlEmail(MailRequest request) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        message.setContent(request.getContent(), "text/html");

        helper.setTo(request.getReciever());

        helper.setSubject(request.getSubject());

        javaMailSender.send(message);
    }


}
