package com.example.demo.dto.login;

import lombok.Data;

@Data
public class SignupRequest {
  String phone;
  String name;
  String password;
}
