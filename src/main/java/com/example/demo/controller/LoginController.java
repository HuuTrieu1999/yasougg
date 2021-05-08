package com.example.demo.controller;


import com.example.demo.dto.login.LoginRequest;
import com.example.demo.dto.login.LoginResponse;
import com.example.demo.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
    LoginResponse response = new LoginResponse();
    try {
      if()
    }
    catch (Exception e){
      response.setCode(-1);
      response.setDiscription("Exception: "+e.getMessage());
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

//  @PostMapping("/logout")
//  public ResponseEntity<LoginResponse> logout(@RequestBody LoginRequest request){
//
//  }

  @PostMapping("/signup")
  public ResponseEntity<LoginResponse> signup(@RequestBody LoginRequest request){

  }
}
