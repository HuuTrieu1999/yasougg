package com.paylinks.controller;


import com.paylinks.dto.login.LoginRequest;
import com.paylinks.dto.login.LoginResponse;
import com.paylinks.dto.login.SignupRequest;
import com.paylinks.dto.login.SignupResponse;
import com.paylinks.service.LoginService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  Map<String, Integer> map = new HashMap<>();

  @Autowired
  LoginService loginService;

  @GetMapping("/ping")
  public String ping(){
    return "Ok";
  }

  @CrossOrigin
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
    Random random = new Random();
    LoginResponse response = new LoginResponse();
    try {
      if(loginService.login(request.getPhone(), request.getPassword())) {
        int sessionId = random.nextInt(1000000);
        response.setCode(1);
        response.setDiscription("Login success");
        response.setSessionId(sessionId);
        map.put(request.getPhone(), sessionId);
      }
      else {
        response.setCode(-1);
        response.setDiscription("Sai phone hoac password");
      }
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

  @CrossOrigin
  @PostMapping("/signup")
  public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request){
    SignupResponse response = new SignupResponse();
    try {
      if(loginService.signup(request)) {
        response.setCode(1);
        response.setDiscription("Dang ki thanh cong");
      }
      else {
        response.setCode(-1);
        response.setDiscription("Dang ki that bai");
      }
    }
    catch (Exception e){
      response.setCode(-1);
      response.setDiscription("Exception: "+e.getMessage());
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
