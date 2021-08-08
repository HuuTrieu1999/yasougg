package com.paylinks.service;

import com.paylinks.dto.MailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class YasouService {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private JavaMailSender javaMailSender;

  public String send(MailRequest request){
    try {
      sendEmail();
      logger.info("Send email success");
    } catch (Exception e) {
      e.printStackTrace();
      return e.getMessage();
    }
    logger.info("Send done");
    return "Success";
  }

  void sendEmail() {

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("trieuphuhuu1999@gmail.com"); //, "2@yahoo.com");

    msg.setSubject("Testing from Spring Boot CN 17:00");
    msg.setText("Hello World \n Spring Boot Email");

    javaMailSender.send(msg);

  }


}
