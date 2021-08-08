package com.paylinks.controller;

import com.paylinks.dto.MailRequest;
import com.paylinks.service.YasouService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YasouController {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  YasouService yasouService;

  @GetMapping("/ping")
  @CrossOrigin
  public String ping(){
    return "Ok";
  }

  @PostMapping("/send")
  @CrossOrigin
  public String send(@RequestBody MailRequest request){
    String response;
    try {
      response = yasouService.send(request);
    } catch (Exception e) {
      response = e.getMessage();
    }
    logger.info("[API][SendMail] request {} | response {}", request.toString(),response);
    return response;
  }



}
