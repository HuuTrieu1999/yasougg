package com.paylinks.service;

import com.paylinks.dto.FindPathRequest;
import com.paylinks.dto.FindPathResponse;

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

  public FindPathResponse send(FindPathRequest request){
    FindPathResponse response = new FindPathResponse();
    try {
      //sendEmail();
      sendEmail();
      logger.info("Send email success");
    } catch (Exception e) {
      e.printStackTrace();
    }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    System.out.println("Done");
    return response;
  }

  void sendEmail() {

    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("trieuphuhuu1999@gmail.com"); //, "2@yahoo.com");

    msg.setSubject("Testing from Spring Boot 1");
    msg.setText("Hello World \n Spring Boot Email");

    javaMailSender.send(msg);

  }


}
